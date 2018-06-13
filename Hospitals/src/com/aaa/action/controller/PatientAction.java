package com.aaa.action.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aaa.biz.AppItemBiz;
import com.aaa.biz.CureBiz;
import com.aaa.biz.DrugBiz;
import com.aaa.biz.InsItemBiz;
import com.aaa.biz.MedicalRecordBiz;
import com.aaa.biz.OfficeBiz;
import com.aaa.biz.PatientBiz;
import com.aaa.biz.PrescribeBiz;
import com.aaa.biz.TreatmentBiz;
import com.aaa.entity.Appiteminfo;
import com.aaa.entity.Applicationform;
import com.aaa.entity.Applicationitem;
import com.aaa.entity.Cure;
import com.aaa.entity.Drug;
import com.aaa.entity.Insiteminfo;
import com.aaa.entity.Inspection;
import com.aaa.entity.Inspectionitem;
import com.aaa.entity.Lop;
import com.aaa.entity.Medicalrecord;
import com.aaa.entity.Office;
import com.aaa.entity.Pager;
import com.aaa.entity.Patient;
import com.aaa.entity.Patientdetail;
import com.aaa.entity.Patients;
import com.aaa.entity.Prescribe;
import com.aaa.entity.Treatment;
import com.aaa.util.BaseAction;
import com.alibaba.fastjson.JSON;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class PatientAction extends BaseAction {
	@Resource
	private PatientBiz biz;
	@Resource
	private MedicalRecordBiz mrBiz;
	private Patients p;
	private Patientdetail pd;
	private Medicalrecord mr;
	private Treatment t;
	@Resource
	private TreatmentBiz tBiz;
	@Resource
	private OfficeBiz officeBiz;
	@Resource
	private DrugBiz drugBiz;
	private Pager pager;
	private String zhuji;
	private List<Cure> list;
	@Resource
	private CureBiz cureBiz;
	private Cure cure;
	private Drug drug;
	private int pageSize = 3;
	@Resource
	private AppItemBiz appItemBiz;
	private Applicationform applicationform;
	private Inspection inspection;
	@Resource
	private InsItemBiz insBiz;
	@Resource
	private PrescribeBiz prescribeBiz;
	private Prescribe prescribe;
	private List<Lop> lopList;
	private int pid;
	private Lop lop;
    private int patientsid;
    private int jcxId;
    private int jyxId;
    private int[] appList;
    private int[] insList;
    
	public int[] getInsList() {
		return insList;
	}

	public void setInsList(int[] insList) {
		this.insList = insList;
	}

	public int[] getAppList() {
		return appList;
	}

	public void setAppList(int[] appList) {
		this.appList = appList;
	}

	public int getJyxId() {
		return jyxId;
	}

	public void setJyxId(int jyxId) {
		this.jyxId = jyxId;
	}

	public int getJcxId() {
		return jcxId;
	}

	public void setJcxId(int jcxId) {
		this.jcxId = jcxId;
	}

	public int getPatientsid() {
		return patientsid;
	}

	public void setPatientsid(int patientsid) {
		this.patientsid = patientsid;
	}

	public Lop getLop() {
		return lop;
	}

	public void setLop(Lop lop) {
		this.lop = lop;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Prescribe getPrescribe() {
		return prescribe;
	}

	public void setPrescribe(Prescribe prescribe) {
		this.prescribe = prescribe;
	}

	public List<Lop> getLopList() {
		return lopList;
	}

	public void setLopList(List<Lop> lopList) {
		this.lopList = lopList;
	}

	public PrescribeBiz getPrescribeBiz() {
		return prescribeBiz;
	}

	public void setPrescribeBiz(PrescribeBiz prescribeBiz) {
		this.prescribeBiz = prescribeBiz;
	}

	public Inspection getInspection() {
		return inspection;
	}

	public void setInspection(Inspection inspection) {
		this.inspection = inspection;
	}

	public InsItemBiz getInsBiz() {
		return insBiz;
	}

	public void setInsBiz(InsItemBiz insBiz) {
		this.insBiz = insBiz;
	}

	public Applicationform getApplicationform() {
		return applicationform;
	}

	public void setApplicationform(Applicationform applicationform) {
		this.applicationform = applicationform;
	}

	public AppItemBiz getAppItemBiz() {
		return appItemBiz;
	}

	public void setAppItemBiz(AppItemBiz appItemBiz) {
		this.appItemBiz = appItemBiz;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public Cure getCure() {
		return cure;
	}

	public void setCure(Cure cure) {
		this.cure = cure;
	}

	public CureBiz getCureBiz() {
		return cureBiz;
	}

	public void setCureBiz(CureBiz cureBiz) {
		this.cureBiz = cureBiz;
	}

	public List<Cure> getList() {
		return list;
	}

	public void setList(List<Cure> list) {
		this.list = list;
	}

	public String getZhuji() {
		return zhuji;
	}

	public void setZhuji(String zhuji) {
		this.zhuji = zhuji;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public DrugBiz getDrugBiz() {
		return drugBiz;
	}

	public void setDrugBiz(DrugBiz drugBiz) {
		this.drugBiz = drugBiz;
	}

	public OfficeBiz getOfficeBiz() {
		return officeBiz;
	}

	public void setOfficeBiz(OfficeBiz officeBiz) {
		this.officeBiz = officeBiz;
	}

	public PatientBiz getBiz() {
		return biz;
	}

	public void setBiz(PatientBiz biz) {
		this.biz = biz;
	}

	public MedicalRecordBiz getMrBiz() {
		return mrBiz;
	}

	public void setMrBiz(MedicalRecordBiz mrBiz) {
		this.mrBiz = mrBiz;
	}

	public Patients getP() {
		return p;
	}

	public void setP(Patients p) {
		this.p = p;
	}

	public Patientdetail getPd() {
		return pd;
	}

	public void setPd(Patientdetail pd) {
		this.pd = pd;
	}

	public Medicalrecord getMr() {
		return mr;
	}

	public void setMr(Medicalrecord mr) {
		this.mr = mr;
	}

	public Treatment getT() {
		return t;
	}

	public void setT(Treatment t) {
		this.t = t;
	}

	public TreatmentBiz gettBiz() {
		return tBiz;
	}

	public void settBiz(TreatmentBiz tBiz) {
		this.tBiz = tBiz;
	}

	// 患者明細添加
	public void addDetail() {
		biz.addPatientDetail(pd);
		System.out.println("详情表添加成功");
	}

	// 查询患者
	public void find() {
		List<Patients> pList = biz.findPatients();
		this.getPrintWriter().print(JSONArray.fromObject(pList));
	}

	// 患者就诊状态的修改
	public void updateStatus() {
		biz.updateP_status(p);
		System.out.println("修改成功");
	}

	// 病历添加
	public void addMedicalRecord() {
		mrBiz.addMedicalrecord(mr);
		System.out.println("病历添加成功");

	}

	// 治疗类目
	public void findTreatment() {
		List<Treatment> tLiString = tBiz.findTreatment(t.getZjm());
		this.getPrintWriter().print(JSONArray.fromObject(tLiString));
		System.out.println("查询治疗类目成功");
	}

	// 添加治疗表
	public void addCure() {
		cureBiz.addCure(list);
	}

	// 药品查询
	public void findDrugs() {
		if (pager == null)
			pager = new Pager();
		if (drug != null) {// 如果有参数
			String p1 = "%" + drug.getZhuji() + "%";// 设定参数
			pager = drugBiz.findDrug(pager, p1);
		} else {// 没有参数时
			pager = drugBiz.findDrug(pager);
		}
		// pager = drugBiz.findDrug(pager);
		this.getPrintWriter().print(JSONObject.fromObject(pager));// 转换json并输出
		System.out.println(JSONObject.fromObject(pager));
	}

	// 添加处方
	public void addPrescribe() {
		prescribeBiz.addPrescribe(prescribe, lopList);
		System.out.print("添加处方表成功");
	}

	/*-------------------已开处方处置------------------------*/
	/*--------------------------------------------------------*/
	/*--------------------------------------------------------*/
	// 查询处方明细
	public void findLop() {
		this.getPrintWriter().print(JSONArray.fromObject(prescribeBiz.findLop(pid)));
	}

	// 删除处方明细
	public void deleteLop() {
		prescribeBiz.deleteLop(lop);
		System.out.println("删除成功");
	}

	// 修改明细表：修改数量
	public void updateLop() {
		prescribeBiz.updateLop(lop);
	}
    //查询检查申请表
	public void findApplication(){
		List<Applicationform> list=appItemBiz.findApplication(patientsid);
		this.getPrintWriter().print(JSONArray.fromObject(list));
	}
	//查询检验申请
	public void findInspection(){
		List<Inspection> list=insBiz.findInspection(patientsid);
		this.getPrintWriter().print(JSONArray.fromObject(list));
	}
	/*--------------------------------------------------------*/
	/*--------------------------------------------------------*/
	/*--------------------------------------------------------*/
	// 科室查询
	public void findOffice() {
		List<Office> oList = officeBiz.findOffice();
		this.getPrintWriter().print(JSONArray.fromObject(oList));
		System.out.println("科室查询完成");
	}

	// 检查类目查询
	public void findAppItem() {
		List<Applicationitem> list = appItemBiz.findAppItem();
		this.getPrintWriter().print(JSONArray.fromObject(list));
		System.out.println("检查类目查询成功！");
	}
	// 查询检查项目详情
		public void findAppItemInfo(){
			List<Appiteminfo> list=appItemBiz.findAppItemInfo(jcxId);
			this.getPrintWriter().print(JSONArray.fromObject(list));
			System.out.println("YES！！！！！！！！！！！！！！！！");
		}
		//查询检验项目详情
		public void findInsItemInfo(){
			List<Insiteminfo> list=insBiz.findInsItemInfo(jyxId);
			this.getPrintWriter().print(JSONArray.fromObject(list));
			System.out.println("yes66666666");
		}
	// 添加检查申请表
	public void addAppItem() {
		System.out.println("检查申请表准备提交。。。。。。。。。。。。。");
		System.out.println(appList.length+"获取到！！！！！！！！！！！");
		for (int i = 0; i < appList.length; i++) {
			   Appiteminfo appiteminfo=new Appiteminfo();
			   appiteminfo.setAid(appList[i]);
			   applicationform.setAppiteminfo(appiteminfo);
			appItemBiz.addAppItem(applicationform);
		}
		
		System.out.println("检查申请表添加成功");
		
	}

	// 检验类目查询
	public void findInsItem() {
		List<Inspectionitem> list = insBiz.findInsItem();
		this.getPrintWriter().print(JSONArray.fromObject(list));
		System.out.println("检验查询成功");
	}

	// 添加检验申请表
	public void addInsItem() {
		System.out.println(insList.length+"aaaaaa");
		for (int i = 0; i < insList.length; i++) {
			Insiteminfo insiteminfo=new Insiteminfo();
			insiteminfo.setIid(insList[i]);
			inspection.setInsiteminfo(insiteminfo);
			insBiz.addInsItem(inspection);
		}
		System.out.println("添加检验申请表成功");
	}
}
