//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.project.team", window, function(aNamespace) 
{
 aNamespace.message = {

 site :  "site",
 teamid :  "Id.",
 teamdescr :  "Nome Team",
 periodindex :  "Periodo di riferimento",
 periodtype :  "periodtype",
 teamstatus :  "Stato Attivita'",
 templateteamid: "Importa Risorse da",
 queryactionformview_legend: 'Elenco Team',
 detailactionformview_legend: 'Dettaglio Team',
 
 team_empty: 'In fase di composizione', 
 team_building: 'In fase di composizione', 
 team_verifying: 'In verifica composizione', 
 team_reporting: 'In fase di consuntivazione', 
 team_validating: 'In verifica consuntivazione', 
 team_close: 'Chiuso',
 
 oncomplete_ok_action_team_empty: 'No Status', 
 oncomplete_ok_action_team_building: 'Termina Composizione Team', 
 oncomplete_ok_action_team_verifying: 'Procedi con la Consuntivazione', 
 oncomplete_ok_action_team_reporting: 'Chiudi Periodo di consuntivazione', 
 oncomplete_ok_action_team_validating: 'Conferma Consuntivazione', 
 oncomplete_ok_action_team_close: 'No Status',
 getOnCompleteOkActionMessageForTask: function(aStatus)
 {
	 return eval('org.r3.db.project.team.message.oncomplete_ok_action_' + aStatus);
 },

 oncomplete_ko_action_team_empty: 'No Status', 
 oncomplete_ko_action_team_building: 'No Status', 
 oncomplete_ko_action_team_verifying: 'Riapri Composizione Team', 
 oncomplete_ko_action_team_reporting: 'Riapri Composizione Team', 
 oncomplete_ko_action_team_validating: 'Riapri Consuntivazione Team', 
 oncomplete_ko_action_team_close: 'No Status',
 getOnCompleteKoActionMessageForTask: function(aStatus)
 {
	 return eval('org.r3.db.project.team.message.oncomplete_ko_action_' + aStatus);
 }

  };
});


