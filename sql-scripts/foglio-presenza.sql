delete from r3_classifieritem where clsid = 'r3ea_attsheet' and site = 'cvfchamp43';
delete from r3_classifier where clsid = 'r3ea_attsheet' and site = 'cvfchamp43';

INSERT INTO regatta3.r3_classifier (site, clsid, clsdescr, clstypecode, clsambitcode, cacheinterval, etag, rectimestamp)
VALUES ('cvfchamp43', 'r3ea_attsheet', 'R3EA Foglio Presenza', 'linear', 'system', 60, null, '2013-09-18 01:11:34');

INSERT INTO regatta3.r3_classifieritem (clsitemid, site, clsid, clsitembusid, parentitemid, classifieritemdescr, classifieritempath, classifieritemdepth, classifieritemorder, classifieritemiattr, classifieritemsattr)
VALUES ('ats000000000001', 'cvfchamp43', 'r3ea_attsheet', 'ats000000000001', null, '29 Ottobre 2023', null, 0, 10, null, '20231029 10:00');
INSERT INTO regatta3.r3_classifieritem (clsitemid, site, clsid, clsitembusid, parentitemid, classifieritemdescr, classifieritempath, classifieritemdepth, classifieritemorder, classifieritemiattr, classifieritemsattr)
VALUES ('ats000000000002', 'cvfchamp43', 'r3ea_attsheet', 'ats000000000002', null, '12 Novembre 2023', null, 0, 20, null, '20231112 10:00');
INSERT INTO regatta3.r3_classifieritem (clsitemid, site, clsid, clsitembusid, parentitemid, classifieritemdescr, classifieritempath, classifieritemdepth, classifieritemorder, classifieritemiattr, classifieritemsattr)
VALUES ('ats000000000003', 'cvfchamp43', 'r3ea_attsheet', 'ats000000000003', null, '26 Novembre 2023', null, 0, 30, null, '20231126 10:00');
INSERT INTO regatta3.r3_classifieritem (clsitemid, site, clsid, clsitembusid, parentitemid, classifieritemdescr, classifieritempath, classifieritemdepth, classifieritemorder, classifieritemiattr, classifieritemsattr)
VALUES ('ats000000000004', 'cvfchamp43', 'r3ea_attsheet', 'ats000000000004', null, '10 Dicembre 2023', null, 0, 40, null, '20231210 10:00');
INSERT INTO regatta3.r3_classifieritem (clsitemid, site, clsid, clsitembusid, parentitemid, classifieritemdescr, classifieritempath, classifieritemdepth, classifieritemorder, classifieritemiattr, classifieritemsattr)
VALUES ('ats000000000005', 'cvfchamp43', 'r3ea_attsheet', 'ats000000000005', null, '07 Gennaio 2024', null, 0, 50, null, '20240107 10:00');
INSERT INTO regatta3.r3_classifieritem (clsitemid, site, clsid, clsitembusid, parentitemid, classifieritemdescr, classifieritempath, classifieritemdepth, classifieritemorder, classifieritemiattr, classifieritemsattr)
VALUES ('ats000000000006', 'cvfchamp43', 'r3ea_attsheet', 'ats000000000006', null, '21 Gennaio 2024', null, 0, 60, null, '20240121 10:00');
INSERT INTO regatta3.r3_classifieritem (clsitemid, site, clsid, clsitembusid, parentitemid, classifieritemdescr, classifieritempath, classifieritemdepth, classifieritemorder, classifieritemiattr, classifieritemsattr)
VALUES ('ats000000000007', 'cvfchamp43', 'r3ea_attsheet', 'ats000000000007', null, '04 Febbraio 2024', null, 0, 70, null, '20240204 10:00');
INSERT INTO regatta3.r3_classifieritem (clsitemid, site, clsid, clsitembusid, parentitemid, classifieritemdescr, classifieritempath, classifieritemdepth, classifieritemorder, classifieritemiattr, classifieritemsattr)
VALUES ('ats000000000008', 'cvfchamp43', 'r3ea_attsheet', 'ats000000000008', null, '18 febbraio 2024', null, 0, 80, null, '20240218 10:00');
INSERT INTO regatta3.r3_classifieritem (clsitemid, site, clsid, clsitembusid, parentitemid, classifieritemdescr, classifieritempath, classifieritemdepth, classifieritemorder, classifieritemiattr, classifieritemsattr)
VALUES ('ats000000000009', 'cvfchamp43', 'r3ea_attsheet', 'ats000000000009', null, '03 Marzo 2023', null, 0, 90, null, '20240303 10:00');

create or replace view sev_view_attendanceesheet as
select a.eventid, a.applicationid, a.yachtname, a.plate, a.sailnumber, a.completionstatus, clsitemid as sheetid, ad1.paramname as attendanceyesparam, ad1.paramvalue as attendanceyes, ad2.paramname as crewregularparam, ad2.paramvalue as crewregular
from sev_application a join
    (select * from r3_classifieritem where clsid = 'r3ea_attsheet') as cls
    left join  sev_appdata ad1 on a.applicationid = ad1.applicationid and ad1.sectionid = 'r3ea_attsheet' and left(ad1.paramname, 15) = clsitemid and right(ad1.paramname, length(ad1.paramname)-16) = 'attendanceyes'
    left join  sev_appdata ad2 on a.applicationid = ad2.applicationid and ad2.sectionid = 'r3ea_attsheet' and left(ad2.paramname, 15) = clsitemid and right(ad2.paramname, length(ad2.paramname)-16) = 'crewregular'
where a.completionstatus <> 'r3ea_empty';

-- variante per la versione mariadb in produzione
create or replace view sev_view_attendanceesheet as
select a.eventid, a.applicationid, a.yachtname, a.plate, a.sailnumber, a.completionstatus, clsitemid as sheetid, ad1.paramname as attendanceyesparam, ad1.paramvalue as attendanceyes, ad2.paramname as crewregularparam, ad2.paramvalue as crewregular
from sev_application a join
    r3_classifieritem  cls on clsid = 'r3ea_attsheet'
    left join  sev_appdata ad1 on a.applicationid = ad1.applicationid and ad1.sectionid = 'r3ea_attsheet' and left(ad1.paramname, 15) = clsitemid and right(ad1.paramname, length(ad1.paramname)-16) = 'attendanceyes'
    left join  sev_appdata ad2 on a.applicationid = ad2.applicationid and ad2.sectionid = 'r3ea_attsheet' and left(ad2.paramname, 15) = clsitemid and right(ad2.paramname, length(ad2.paramname)-16) = 'crewregular'
where a.completionstatus <> 'r3ea_empty';

select * from sev_view_attendanceesheet
where eventid = 'cvfchamp43'
order by applicationid, sheetid;
