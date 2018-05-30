package com.aaa.daoimpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.dao.PatientsDao;
import com.aaa.entity.Charge;
import com.aaa.entity.Clinicregister;
import com.aaa.entity.Patients;
import com.aaa.util.Pager;
import com.aaa.util.PagerCallBack;
@Repository
public class PatientsDaoImpl implements PatientsDao {
	@Autowired
 private HibernateTemplate ht;

	public HibernateTemplate getHt() {
	return ht;
}

public void setHt(HibernateTemplate ht) {
	this.ht = ht;
}

	/*@Override
	public Pager findByPages(final int curPage,final int pageSize) {
		Pager p=new Pager(curPage, pageSize);
		String hql="select new Map(p.id as id,p.patientname as patientname,p.sex as sex,p.age as age,p.idnumber as idnumber) from Patients p";
		List list=this.ht.executeFind(new PagerCallBack<List<Patients>>(hql,null,(curPage-1)*pageSize, pageSize));
		List<Long> list2=this.ht.find("select count(*) from Patients");
		p.setList(list);
		p.setTotalCount(Integer.valueOf(list2.get(0).toString()));
		String hql2="select count(*) from Patients";
		pager p=this.ht.execute();
		return p;
	}*/

@Override
public Pager findByPages(final int curPage,final int pageSize) {
	Pager p=new Pager(curPage, pageSize);
	String hql="select new Map(c.registerId as registerId,c.serialNumber as serialNumber,p.id as id,p.patientname as patientname,p.sex as sex,p.age as age,s.stuffname as stuffname,r.typeName as typeName,o.officeName as officeName,e.sfId as sfId,e.charge as charge,e.realCharge as realCharge,e.changes as changes,c.presentTime as presentTime) from Clinicregister c join c.patients p join c.stuff s join c.office o join c.registeredtype r join c.charge e";
	List list=this.ht.executeFind(new PagerCallBack<List<Clinicregister>>(hql,null,(curPage-1)*pageSize, pageSize));
	List<Long> list2=this.ht.find("select count(*) from Clinicregister");
	p.setList(list);
	p.setTotalCount(Integer.valueOf(list2.get(0).toString()));
	/*String hql2="select count(*) from Patients";*/
	/*pager p=this.ht.execute();*/
	return p;
}

	@Override
	public void save(Patients patients) {
		this.ht.save(patients);
	}

	@Override
	public void update(Patients patients) {
		this.ht.update(patients);
		
	}

	@Override
	public Map findById(Patients patients) {
		/*String hql="select new Map(id as id,patientname as patientname,sex as sex,age as age,idnumber as idnumber) from Patients where id=?";*/
		//System.out.println((Map) this.ht.find(hql,id).get(0));
		String hql="select new Map(p.id as id,p.patientname as patientname,p.sex as sex,p.age as age,p.idnumber as idnumber) from Patients p where p.id="+patients.getId();
		/*List<Map> list=this.ht.find(hql, patients.getId());*/
		/*this.getHt().get(Patients.class,patients.getId());*/
		List<Map> list=this.ht.find(hql);
		return list.get(0);
		
	}

	@Override
	public void delete(Patients patients) {
		System.out.println(patients+"daoimpl---"+patients.getId());
		this.ht.delete(patients);
		
	}

	@Override
	public List<String> findByKey(String key) {
		System.out.println("key"+key);
		List<String> list=this.ht.find("select p.patientname from Clinicregister c join c.patients p where p.patientname like '%"+key+"%'");
		return list;
	}

	@Override
	public Map findByName(Patients patients) {
		String hql="select new Map(c.registerId as registerId,c.serialNumber as serialNumber,c.iphone as iphone,p.id as id,p.patientname as patientname,p.sex as sex,p.age as age,p.idnumber as idnumber,p.date as date,p.status as status,s.stuffid2 as stuffid2,s.stuffname as stuffname,r.ghId as ghId,r.typeName as typeName,o.officeId as officeId,o.officeName as officeName,e.sfId as sfId,e.charge as charge,e.chargeable as chargeable,e.realCharge as realCharge,e.changes as changes,c.presentTime as presentTime) from Clinicregister c join c.patients p join c.stuff s join c.office o join c.registeredtype r join c.charge e where p.patientname="+"'"+patients.getPatientname()+"'";
		List<Map> list=this.ht.find(hql);
		return list.get(0);
	}

	@Override
	public void deleteClinicregister(Clinicregister clinicregister) {
		this.ht.delete(clinicregister);
	}

	@Override
	public void deleteCharge(Charge charge) {
		this.ht.delete(charge);
	}

	@Override
	public List<Map> findOffice() {
		String hql="select new Map(o.officeId as officeId,o.officeName as officeName) from Office o";
		List<Map> list=this.ht.find(hql);
		System.out.println("findOffice:"+list);
		return list;
	}

	@Override
	public List<Map> findStuff() {
		String hql="select new Map(s.stuffid2 as stuffid2,s.stuffname as stuffname) from Stuff s";
		List<Map> list=this.ht.find(hql);
		return list;
	}

	@Override
	public List<Map> findRegisteredtype() {
		String hql="select new Map(r.ghId as ghId,r.typeName as typeName) from Registeredtype r";
		List<Map> list=this.ht.find(hql);
		return list;
	}

	@Override
	public void saveClinicregister(Clinicregister clinicregister) {
		/*String p=getNewId();
		clinicregister.setSerialNumber(p);*/
		this.ht.save(clinicregister);
		
	}

	@Override
	public void savePatients(Patients patients) {
	
		this.ht.save(patients);
	}

	@Override
	public void saveCharge(Charge charge) {
		this.ht.save(charge);
		
	}

	@Override
	public void updateClinicregister(Clinicregister clinicregister) {
		this.ht.update(clinicregister);
		
	}

	@Override
	public void updatePatients(Patients patients) {
		this.ht.update(patients);
		
	}

	@Override
	public void updateCharge(Charge charge) {
		this.ht.update(charge);
		
	}

	@Override
	public String getNewId() {
		final String sql="select lpad(max(cast(c.serialNumber as signed))+1,3,'0') from clinicRegister c";
		String result=this.ht.execute(new HibernateCallback<String>() {

			@Override
			public String doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=session.createSQLQuery(sql);
				String results=query.uniqueResult().toString();
				return results;
			}
		});
		return result;
	}

}
