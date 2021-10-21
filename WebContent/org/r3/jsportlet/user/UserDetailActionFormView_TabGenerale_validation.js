
$.r3Utils.namespace("org.r3.jsportlet.user", window, function(aNamespace) 
{
	
	// Prodotto...
	aNamespace.userdetailactionform_form_validationRules =
	{
		nickname :
		{
			required : true,
			maxlength: 10
		},

		password :
		{
			required : true,
			maxlength: 10
		},

		confpasswd :
		{
			required : true,
			maxlength: 10,
			equalTo: '#userdetailactionform_form_password'
		},

		username :
		{
			required : true,
			maxlength: 80
		},

		usertype :
		{
			required : true
		},

		idareaorganizzativa :
		{
			required : true
		},

		idcentrolavorazione :
		{
			required : true
		},

		idcentroesiti :
		{
			required : true
		},

		idgruppo :
		{
			required : false
		},

		idcliente :
		{
			required : false
		},
		
		ruolipostaliz :
		{
			required : true
		},
		
		ruoliesiti :
		{
			required : true
		}				

	};

	aNamespace.userdetailactionform_form_validationMessages =
	{
			nickname :
			{
				required : "Inserire l'account dell'utente",
				maxlength: "La valorizzazione eccede i limiti conesntiti"
			},

			password :
			{
				required : "Inserire la parola chiave dell'utente",
				maxlength: "La valorizzazione eccede i limiti conesntiti"
			},

			confpasswd :
			{
				required : "Inserire la parola chiave di conferma dell'utente",
				maxlength: "La valorizzazione eccede i limiti consentiti",
				equalTo: "La parola chiave di conferma non corrisponde alla parola chiave inserita"
			},

			username :
			{
				required : "Inserire il nominativo dell'utente",
				maxlength: "La valorizzazione eccede i limiti conesntiti"
			},

			usertype :
			{
				required : "Inserire il tipo dell'operatore"
			},

			idareaorganizzativa :
			{
				required : "Inserire l'ALT"
			},

			idcentrolavorazione :
			{
				required : "Inserire il Centro Lavorazione"
			},

			idcentroesiti :
			{
				required : "Inserire il Centro Esiti"
			},

			idgruppo :
			{
				required : "Inserire il Gruppo"
			},

			idcliente :
			{
				required : "Inserire il Cliente"
			},
			
			ruolipostaliz :
			{
				required : "Inserire il/i ruoli dell'utente"
			},
			
			ruoliesiti :
			{
				required : "Inserire il/i ruoli dell'utente"
			}				
	};

});
