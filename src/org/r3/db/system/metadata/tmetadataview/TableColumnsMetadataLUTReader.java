package org.r3.db.system.metadata.tmetadataview;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.NamingException;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase;
import org.r3.db.PersistenceContext;
import org.r3.db.PersistenceDTO;
import org.r3.db.system.lut.LUTException;
import org.r3.db.system.lut.LUTReader;
import org.r3.db.system.lut.LUTTable;
import org.scannotation.AnnotationDB;
import org.scannotation.ClasspathUrlFinder;





public class TableColumnsMetadataLUTReader extends LUTReader
{

	public LUTTable readLUT() throws LUTException
	{
		LUTTable table = new LUTTable();		
		
		PersistenceContext pcfg = PersistenceContext.getPersistenceContext();
		SqlSession session = pcfg.openSession();
		
		try
		{
			List<Class> listOfClasses = scanClasses4Annotations(DTOBase.class, PersistenceDTO.class);
			if (listOfClasses != null)
			{
			TableColumnsMetadataPersistence p = TableColumnsMetadataPersistence.createPersistenceObject(pcfg, session);
			
			for(Class annotatedClass : listOfClasses)
			{
				PersistenceDTO sqlPersistenceEntityAnnotation = (PersistenceDTO)annotatedClass.getAnnotation(PersistenceDTO.class);	
				System.out.println(String.format("### Loading Table Metadata - %s", sqlPersistenceEntityAnnotation.table_name())); 
				
				TableColumnsMetadataFilter filter = new TableColumnsMetadataFilter();
				
				filter.or().andTable_schemaEqualTo(sqlPersistenceEntityAnnotation.schema_name().isEmpty() ? null : sqlPersistenceEntityAnnotation.schema_name().toUpperCase()).andTable_nameEqualTo(sqlPersistenceEntityAnnotation.table_name().toUpperCase());
				
				List<TableColumnsMetadataDTO> listOf = p.select(filter, pcfg.getPersistenceConfigInfo());
				for (TableColumnsMetadataDTO dto : listOf)
				{
					System.out.println(String.format("### Loading Table Metadata - %s", dto.getDtokey(false))); 					
					addToTable(table, dto);
				}
			}

			postReadLUTProcessing(table);			
			session.commit();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			// In questo caso non genero una exception Ci potrebbe essere un problema di permessi. In questo caso ogni eventuale validazione verra' disabilitata.
			// throw new LUTException(e.getMessage());
		}
		finally
		{
			session.close();
		}

		return table;
	}

	public List<Class> scanClasses4Annotations(Class baseClass, Class targetAnnotationClass) throws Exception
    {
		List<Class> listOfClasses = null;
		
    	URL baseURL = ClasspathUrlFinder.findClassBase(baseClass);
    	System.out.println(String.format("### Metadata Dictionary From URL: %s", baseURL.toString()));
    	
    	AnnotationDB db = new AnnotationDB();
        db.scanArchives(baseURL);

        Map<String, Set<String>> annotationIndex = db.getAnnotationIndex();
        System.out.println(String.format("### Metadata Dictionary  - DBIndex Size: %d", annotationIndex != null ? annotationIndex.size(): 0));
    	
        if (annotationIndex != null)
        {
//        	Set<String> annotationKeySet = annotationIndex.keySet();
//        	for(String s: annotationKeySet)
//        	{
//            	System.out.println(String.format("### INITCONTEXT LISTENER: ScanAnnotatedClasses - FoundAnnotations: %s", s));        		
//        	}
        	
        	Set<String> annotatedClasses = annotationIndex.get(targetAnnotationClass.getName());
        	if (annotatedClasses != null)
        	{
        		for(String className : annotatedClasses)
        		{
            		System.out.println(String.format("### Metadata Dictionary  - %s Annotated Class: %s", targetAnnotationClass.getName(), className)); 
            		try
            		{
            			Class annotatedClass = Class.forName(className);
            	        if (listOfClasses == null)
            	        {
            	        	listOfClasses = new ArrayList<Class>();
            	        }            	        
            	        
        	        	listOfClasses.add(annotatedClass);
            		}
            		catch(Exception exc)
            		{
            			exc.printStackTrace();
            		}
        		}
        		             		
        	}        	
        }
        
        return listOfClasses;
    }
}
