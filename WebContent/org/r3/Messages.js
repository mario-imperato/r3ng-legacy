
$.r3Utils.namespace("org.r3", window, function(aNamespace) 
{
  aNamespace.message = {
    waiting:"Attendi...",
    initializationerror: "Attenzione: si � verificato un errore durante la fase di inizializzazione della pagina. La lavorazione non pu&ograve; proseguire",
    saveconfirm: "Sei sicuro di voler salvare i dati inseriti?",
    deleteconfirm: "Sei sicuro di voler procedere con la cancellazione dell'elemento?",
    deletemulticonfirm: "Sei sicuro di voler procedere con l'eliminazione degli elementi selezionati?",
    sessionreleaseconfirm: "Sei sicuro di voler rilasciare la sessione di lavoro corrente?",
    sessioncommitconfirm: "Sei sicuro di voler confermare la sessione di lavoro corrente?",
    defaultBlankOptionText: "-- Selezionare --",
    tasksNotFound: "Non vi sono elementi da lavorare che verificano le condizioni indicate",
    success: "Operazione eseguita con successo",
    closeSession_OK: "La lavorazione � terminata con successo!",
    
    field_email: "Il valore immesso non risulta essere un indirizzo di posta elettronica valido",
    field_identifier: "Il campo deve iniziare con una lettera e puo' contenere solo caratteri alfabetici e numeri",
    field_lettersNumbersPunctuation: "Il nome del cliente non puo' contenere caratteri speciali.",
    field_noSpecialCharacters: "Caratteri speciali non sono ammessi",
    field_required: "Il campo e\' obbligatorio.",
    field_sailnumber: "Inputare un numero velico valido. Es. ITA15083",
    field_number: "Il valore indicato deve rappresentare un numero. Il '.' (punto) separa i decimali",
    field_maxlength: "Il numero di caratteri eccede i limiti consentiti",
    field_minlength: "Digitare almeno {0} caratteri",
    
    field_dpDate: "Indicare una data valida",
    field_dpDateCompare: "Indicare una data valida",
    
    field_dpArrayCompareDate: "La data indicata non rappresenta una data valida",
    field_dpDateRange: "Le date indicate non rappresentano un periodo valido",
    field_dpDateNotAfterToday: "La data indicata non deve essere nel futuro",
    field_dpDateNotBeforeToday: "La data indicata non deve essere nel passato",
    field_dpDateNotAfterTodayAndRange: 'La data indicata non pu� essere nel futuro e deve costituire un intervallo valido',
    field_digits: "Sono ammessi solo caratteri numerici",
    field_range: "Il valore indicato eccede i limiti consentiti",
    field_date_check: "Confermare la data inserita",
    field_codiceraccomandata: "Il valore immesso non corrisponde ad un codice valido",
    field_checkbox_minlength: "Selezionare tutte le opzioni disponibili",
    field_dpDateIntervalTooBig: "L'intervallo di selezione risulta troppo esteso (Max. 3 mesi)",
    field_greaterOrEqualThan: "Il valore indicato non rappresenta un intervallo valido",
    field_greaterThan: "Il valore indicato non rappresenta un intervallo valido.",
    field_isNotCAD: "Il valore indicato non rappresenta un codice CAD valido",
    field_isNotCAN: "Il valore indicato non rappresenta un codice CAN valido",
    field_min: "Il valore deve essere superiore o uguale a {0}",
    field_max: "Il valore deve essere inferiore o uguale a {0}",
    field_timevalue: "Il valore deve essere nel formato hh:mm",
    
    calendar_confirmmove: "[MV] Sei sicuro di voler modificare la voce corrente del calendario?",
    calendar_confirmresize: "[RS] Sei sicuro di voler modificare la voce corrente del calendario?",
    calendar_confirmdelete: "Sei sicuro di voler cancellare la voce corrente del calendario?",
    RESTDTO_ERROR_DUPCODE: "Codice Duplicato. Inserire un valore diverso",
    RESTDTO_OK: "Operazione Terminata con successo",
    RESTDTO_FAIL: "Si e' verificato un errore durante l'esecuzione dell'operazione",
    RESTDTO_UnexpectedError: "Errore di lavorazione inatteso. Contattare l'amministratore",
    RESTDTO_NotYetFinished: "Ci scusiamo per l'inconveniente ma la funzione non e' ancora stata implementata",
    RESTDTO_ERROR_DUPTEAMRESOURCE: "La risorsa è già associata al team indicato",
    RESTDTO_ERROR_DUPTEAMPERIOD: "E' già presente un Team che copre il periodo indicato",
    ERR_LOGIN_001: "Errore di autenticazione (1)",
    ERR_LOGIN_002: "Errore di autenticazione (2)",
    ERR_FBLOGIN_00C: "Errore di verifica credenziali Facebook (C)",  
    ERR_FBLOGIN_00E: "Errore di verifica credenziali Facebook (E)",    
    ERR_FBLOGIN_001: "Errore di verifica credenziali Facebook (1)",
    ERR_FBLOGIN_002: "Errore di verifica credenziali Facebook (2)",
    ERR_FBLOGIN_003: "Errore di verifica credenziali Facebook (3)",
    
    RESTDTO_ERROR_357: "Codice Scheda gia' presenta a sistema",
    RESTDTO_ERROR_358: "Codice Scheda Non Ammissibile Per il Contesto corrente",
    
    RESTDTO_ERROR_PRJ_001: "Non e' possibile dichiarare completa la composizione di un team privo di risorse assegnate",
    RESTDTO_ERROR_PRJ_002: "Non è possibile procedere alla consuntivazione in quanto il team presenta risorse non completamente configurate",
    
    USR_ERROR_DUPUSER: "Esiste gia' un utente registrato a sistema in corrispondenza della mail indicata. Modificare i dati inseriti oppure procedere al ripristino della parola chiave",
    USR_ERROR_001: "Utente gia' presente a sistema",
    USR_ERROR_002: "La mail indicata non e' conosciuta al sistema",
    USR_ERROR_003: "Il cambio della password non e' andato a buon fine. E' possibile che la parola chiave corrente impostata risulti errata.",
    CAPTCHA_ERROR_001: "Codice di sicurezza non valido",
    ACTOR_ERROR_001: "E' gia' presente un contatto con la mail indicata",
    
    SEV_ERR_0001: "La domanda di iscrizione non puo' essere chiusa in quanto non risulta completa. Nella pagina sono riportati dettagli maggiori. Grazie.",
    
    CLSF_0001: "Il codice indicato di classificazione risulta già presente a sistema e non puo' essere duplicato. Modificare codice e ripetere l'operazione.",
    CLSF_0002: "Il codice indicato di classificazione non risulta presente a sistema.",
    
    CALENDAR_001: "Attenzione: non pu� essere indicata una data corrispondente ad un giorn festivo",
    DUPMEMBERSHIPID: "Il numero di tessera risulta gia' in uso ad un altro utente.",
    
    multiselect_nonselectedtext: "Seleziona",
    multiselect_nselectedtext: "- Too many options selected!",
    multiselect_allSelectedText: " Tutti selezionati",
    multiselect_selectAllText: 'Seleziona tutti!',
    
    default_datepickerOptions: 
    {
    	format: "dd/mm/yyyy",    	
    },
    
    default_timepickerOptions:
    {
		showMeridian: false
	},
    
    default_momentDateFormat: "DD/MM/YYYY",
    
    getDefaultMultiSelectOptions: function() 
    {
        var opts = {
           "nonSelectedText": this.multiselect_nonselectedtext,
           "nSelectedText" : this.multiselect_nselectedtext,
           "allSelectedText": this.multiselect_allSelectedText,
           
           "includeSelectAllOption": false,
           "selectAllText": this.multiselect_selectAllText,
           selectAllValue: 'select-all-value'
           
        };
        
        return opts;       
    },
    
    default_calendar_options:
    {
    	timeFormat: 'H(:mm)',
		defaultView: 'month',
		selectable: true,
		selectHelper: true,
		lang: 'it',
		aspectRatio: 2,

		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay'
		}
		
    },
    
    getDefaultAcceptedCMSFileTypes: function()
    {
        return [ 'png', 'jpg', 'jpeg', 'pdf', 'html', 'htm', 'gif', 'docx', 'xslx', 'doc', 'xsl', 'ppt', 'pptx', 'zip' ];    	
    },
        
    get3LettersMonthNames: function(aZeroBasedMonthIndex)
    {
    	var m = [ 'Gen', 'Feb', 'Mar', 'Apr', 'Mag', 'Giu', 'Lug', 'Ago', 'Set', 'Ott', 'Nov', 'Dic' ];
    	return m[aZeroBasedMonthIndex];
    },
    
    no_second_ago: "Adesso",
    a_second_ago: "Un Secondo Fa",
    seconds_ago: "Secondi Fa",
    a_minute_ago: "Un Minuto Fa",    
    minutes_ago: "Minuti Fa",
    an_hour_ago: "Un'Ora Fa",
    hours_ago: "Ore Fa",
    a_day_ago: "Un Giorno Fa",    
    days_ago: "Giorni Fa",
    a_month_ago: "Un Mese Fa",    
    months_ago: "Mesi Fa",
    an_year_ago: "Un Anno Fa",
    years_ago: "Anni Fa",
    approximately: "Circa",
    
    RESTDTO_ERROR_1000: "Codice gia' presente a sistema",
    RESTDTO_ERROR_ID_DUP: "Codice Identificativo gia' presente a sistema. Non pu� essere duplicato.",

    action_save: "Salva",
    action_publish: "Pubblica",    
    action_draft: "In Bozza",    
    action_cancel: "Annulla",
    action_confirm: "Conferma",
    action_accept: "Accetta",
    action_continue: "Continua",
    action_select: "Seleziona",
    action_new: "Nuovo",
    action_delete: "Elimina",
    action_print: "Stampa",
    action_printable_version: "Versione Stampabile",
    action_back: "Indietro",
    action_confirm_request: 'Conferma Richiesta',
    action_export :	"Esporta",
    action_refresh: 'Aggiorna',
    action_cancel_refresh: 'Annulla Aggiornamento',
    action_insert: 'Inserisci',
    action_upload: 'Upload',
    action_upload_addfile : 'Aggiungi File...',
    action_upload_startupload  : 'Inizia Caricamento',
    action_upload_cancelupload : 'Annulla Caricamento',    
    action_copyurl2clipboard: 'Copia URL to ClipBoard',

    boolean_btrue: "Si'",
    boolean_bfalse: "No"
    
    
    
  };
});
