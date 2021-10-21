
$.r3Utils.namespace("org.r3.jsportlet.user", window, function(aNamespace) 
{
	
	// Prodotto...
	aNamespace.changepasswordactionform_form_validationRules =
	{

		password :
		{
			required : true,
			maxlength: 10
		},

		confpasswd :
		{
			required : true,
			maxlength: 10,
			equalTo: '#changepasswordactionform_form_password'
		}

	};

	aNamespace.changepasswordactionform_form_validationMessages =
	{
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
			}
	};

});
