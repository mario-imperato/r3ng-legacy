<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
  
    <div id="mapexplorer-sidebar" class="sidebar collapsed">
        <!-- Nav tabs -->
        <div class="sidebar-tabs">
            <ul role="tablist">
                <li><a href="#findPlaces" role="tab"><i class="fa fa-search"></i></a></li>
                
                <li id='mapexplorer-tab-neib'      class="disabled"><a href="#mapexplorer-neib" role="tab"><i class="fa fa-users"></i></a></li>
                <li id='mapexplorer-tab-neib-news' class="disabled"><a href="#mapexplorer-neib-news" role="tab"><i class="fa fa-newspaper-o"></i></a></li>                
                <li id='mapexplorer-tab-newsite'                   ><a href="#mapexplorer-newsite" role="tab"><i class="fa fa-user-plus"></i></a></li>
                <li id='mapexplorer-tab-newshop'                   ><a href="#mapexplorer-newshop" role="tab"><i class="fa fa-cart-plus"></i></a></li>
            </ul>

            <ul role="tablist">
                <li><a href="#mapexplorer-help" role="tab"><i class="fa fa-question"></i></a></li>
            </ul>
        </div>

        <!-- Tab panes -->
        <div class="sidebar-content">
            <div class="sidebar-pane" id="findPlaces">
            
                <h1 class="sidebar-header" style='margin-bottom: 20px'>
                    Trova Vicinati
                    <span class="sidebar-close"><i class="fa fa-caret-left"></i></span>
                </h1>

				<div id="mapexplorerform_fieldsetmessage" ></div>                
              
                <form id="mapexplorerform_form" >
                <input type='hidden' name='addressrequired' value='btrue' />
                
                <div class="form-group">
                <label for="exampleInputEmail1">Filtra per tipo</label>
                <select name="sitetype" class="form-control" id="mapexplorerform_sitetype" >
                	<option value=''>-- Selezionare --</option>
                	<option value='shkneighb'>Vicinati</option>                	
                	<option value='shkshop'>Operatori Economici</option>                	
                </select>
                </div>

				<div id='mapexplorerform_address'>
                <div class="form-group">
                <label >Reg. Prov. Localita'</label>
                <select name="area_level_1_id" class="form-control" id="mapexplorerform_area_level_1_id" >
                	            	
                </select>
                </div>                                

                <div class="form-group">
                <!-- <label >Provincia</label> -->
                <select name="area_level_2_id" class="form-control" id="mapexplorerform_area_level_2_id" >
                	            	
                </select>
                </div>                                

                <div class="form-group">                
                <!-- <label >Citta'</label>  -->
                <select name="area_level_3_id" class="form-control" id="mapexplorerform_area_level_3_id" >
                	            	
                </select>
                </div>                                
                </div>
                
                <div class="form-group">
                <label for="exampleInputEmail1">Limita la ricerca a</label>
                <select name="iDisplayLength" class="form-control" id="mapexplorerform_idisplaylength" >
                	<option value='10'>10 Risultati</option>
                	<option value='20'>20 Risultati</option>
                </select>
                </div>
                
                <div class="checkbox">
			    <label>
			      <input type="checkbox" id="mapexplorerform_limit2favsites" value='btrue' name='limit2favsites'> Solo i miei vicinati
			    </label>
                </div>
                
                <div class="form-action-bar">
        		<button type="button" id="mapexplorerform_queryneighborhoods" class="btn btn-default" >
          			<span>Cerca</span>
               </button>
               </div>   
                </form>                
                
            </div>

            <div class="sidebar-pane" id="mapexplorer-neib">
                <h1 class="sidebar-header"><span class="title">Profile</span><span class="sidebar-close"><i class="fa fa-caret-left"></i></span></h1>
                <div class='sidebar-pane-body'>
                </div>
            </div>

            <div class="sidebar-pane" id="mapexplorer-neib-news">
                <h1 class="sidebar-header">Notizie<span class="sidebar-close"><i class="fa fa-caret-left"></i></span></h1>
                <div class='sidebar-pane-body' >
                </div>
            </div>

            <div class="sidebar-pane" id="mapexplorer-newsite">
                <h1 class="sidebar-header">Nuovo Vicinato<span class="sidebar-close"><i class="fa fa-caret-left"></i></span></h1>
                <div class='sidebar-pane-body'>                               
                
                <div class="page-header" style="padding-bottom: 8px; border-bottom: 1px solid #dddddd;">
			    <h1 style="color: #CF221B;">Crea Un Nuovo Vicinato</h1>
    			<p>Sei un’associazione sportiva (ASD/SSD)? Crea ora il tuo profilo e connettiti con le realtà intorno a te.</p>
				</div>

				<div class='clearfix'>
				<a href="/r3ng/shakeus/it/org/r3/newNeighborhood.do" class='btn btn-primary pull-right' style='color: #fff'>Nuovo Vicinato</a>
                </div>
                
 				<figure class="bw" style='margin-top: 10px; margin-bottom: 5px'>
					<img src="/r3ng/org/r3/shakeus/newsite/neighborhood/new-profile-asd.png" style="width: 100%" />
				</figure>
				
                </div>                
            </div>

            <div class="sidebar-pane" id="mapexplorer-newshop">
                <h1 class="sidebar-header">Nuovo Operatore Economico<span class="sidebar-close"><i class="fa fa-caret-left"></i></span></h1>
                <div class='sidebar-pane-body'>

                <div class="page-header" style="padding-bottom: 8px; border-bottom: 1px solid #dddddd;">			    
			    <h1 style="color: #CF221B;">Crea Un Nuovo Operatore Economico</h1>
    			<p>Sei un Esercente o un Professionista? Crea il tuo profilo e inizia ad esplorare i Vicinati Sportivi.</p>
				</div>
				                	
											                
				<div class='clearfix'>
                <a href="/r3ng/shakeus/it/org/r3/newShop.do" class='btn btn-primary  pull-right' style='color: #fff'>Nuovo Operatore Economico</a>
                </div>
                
          		<figure class="bw" style='margin-top: 10px; margin-bottom: 5px'>
					<img src="/r3ng/org/r3/shakeus/newsite/shop/new-profile-oel.jpg" style="width: 100%" />
				</figure>
          
                </div>
            </div>
            
            <div class="sidebar-pane" id="mapexplorer-help">
                <h1 class="sidebar-header">Aiuto Breve<span class="sidebar-close"><i class="fa fa-caret-left"></i></span></h1>
                <p class="lorem">Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.</p>                
            </div>
        </div>
    </div>
    
    <div id="mapexplorer-leafletmap" class="sidebar-map" style='height: 100%; width: 100%'></div> 
     
  
 