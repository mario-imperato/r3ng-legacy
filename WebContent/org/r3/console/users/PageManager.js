$.r3Utils.namespace("org.r3.console.users");

org.r3.console.users.PageManager =
{

	init : function()
	{
		this.userQueryActionForm = new org.r3.console.users.UserQueryActionForm(this, '#userQueryActionForm', '#userQueryAdvancedSearchActionForm');
		this.userDetailActionForm = new org.r3.jsportlet.user.UserDetailActionForm(this, '#userDetailActionForm');
		this.searchUsers();
	},

	searchUsers : function()
	{
		org.r3.PageManager.pushHomeConsoleBreadCrumb();	
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Gestione Utenti",
			"actionForm" : this.userQueryActionForm
		});

		this.userQueryActionForm.open();
	},

	newUser : function()
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Nuova utenza",
			"actionForm" : this.userDetailActionForm
		});
		this.userDetailActionForm.open(null);
	},

	detailUser : function(userDataBean)
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Det. Utenza",
			"actionForm" : this.userDetailActionForm
		});

		var dataBeanInfo =
		{
			"userDataBean" : userDataBean
		};

		this.userDetailActionForm.open(dataBeanInfo);
	}
};
