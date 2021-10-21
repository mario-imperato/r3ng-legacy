$.r3Utils.namespace("org.r3.jsportlet.sev.application", window, function(aNamespace)
{
	aNamespace.authorinfoform_form_validationRules =
	{
		company :
		{
			required : true
		},

		vatnumber :
		{
			required : true
		},

		legalname :
		{
			required : true
		},

		legalsurname :
		{
			required : true
		},

		emailbe :
		{
			required : true,
			email: true
		},

		emailbe2 :
		{
			required : true,
			email: true,
			equalTo: '#companyinfoform_emailbe'
		},

		countryid :
		{
			required : true
		},

		state :
		{
			required : true
		},

		city :
		{
			required : true
		},

		zipcode :
		{
			required : true
		},

		address :
		{
			required : true
		},

		website :
		{
			required : false
		},

		legalformid :
		{
			required : false
		},

		registercode :
		{
			required : true
		},

		counterpartname :
		{
			required : false
		},

		counterpartsurname :
		{
			required : false
		},

		mail :
		{
			required : false,
			email: true
		},

		mail2 :
		{
			required : false,
			email: true,
			equalTo: '#companyinfoform_mail'
		},

		phoneCode1 :
		{
			required : false
		},

		phoneCode2 :
		{
			required : false
		},

		phone1 :
		{
			required : false
		},

		phone2 :
		{
			required : false
		}

	};

	aNamespace.authorinfoform_form_validationMessages =
	{
		company :
		{
			required : org.r3.message.field_required
		},

		vatnumber :
		{
			required : org.r3.message.field_required
		},

		legalname :
		{
			required : org.r3.message.field_required
		},

		legalsurname :
		{
			required : org.r3.message.field_required
		},

		emailbe :
		{
			required : org.r3.message.field_required,
			email: org.r3.message.field_email			
		},

		emailbe2 :
		{
			required : org.r3.message.field_required,
			email: org.r3.message.field_email,
			equalTo: 'Il valore risulta difforme da quello inputato nel campo collegato'						
		},

		countryid :
		{
			required : org.r3.message.field_required
		},

		state :
		{
			required : org.r3.message.field_required
		},

		city :
		{
			required : org.r3.message.field_required
		},

		zipcode :
		{
			required : org.r3.message.field_required
		},

		address :
		{
			required : org.r3.message.field_required
		},

		website :
		{
			required : org.r3.message.field_required
		},

		legalformid :
		{
			required : org.r3.message.field_required
		},

		registercode :
		{
			required : org.r3.message.field_required
		},

		counterpartname :
		{
			required : org.r3.message.field_required
		},

		counterpartsurname :
		{
			required : org.r3.message.field_required
		},

		mail :
		{
			required : org.r3.message.field_required,
			email: org.r3.message.field_email												
		},

		mail2 :
		{
			required : org.r3.message.field_required,
			email: org.r3.message.field_email,
			equalTo: 'Il valore risulta difforme da quello inputato nel campo collegato'									
		},

		phoneCode1 :
		{
			required : org.r3.message.field_required
		},

		phoneCode2 :
		{
			required : org.r3.message.field_required
		},

		phone1 :
		{
			required : org.r3.message.field_required
		},

		phone2 :
		{
			required : org.r3.message.field_required
		}
		
	};

});
