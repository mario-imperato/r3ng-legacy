//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.actor.group");

org.r3.db.actor.group.ActorGroupDTO = Class.extend({
	init : function(aDataBean) {
		this.dtrowclass = "grade_actorgroup";
		this.dtokey = aDataBean.dtokey || null;
		this.dtodescr = aDataBean.dtodescr || null;

		this.eventid = aDataBean.eventid || null;
		this.groupid = aDataBean.groupid || null;
		this.grouptitle = aDataBean.grouptitle || null;
		this.groupnature = aDataBean.groupnature || null;
		this.grouptype = aDataBean.grouptype || null;
		this.groupprofile = aDataBean.groupprofile || null;
		this.businesskey = aDataBean.businesskey || null;
		this.grouporder = aDataBean.grouporder || null;

	}

	,
	compareTo : function(anItemId) {
		if (!this.dtokey)
			return -99;

		if (this.dtokey < anItemId)
			return -1;
		else if (this.dtokey > anItemId)
			return 1;

		return 0;
	}
});
