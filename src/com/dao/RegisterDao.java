package com.dao;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import com.dao.MyConnection;
import com.bean.CertificateBean;
import com.bean.DiseaseBean;
import com.bean.DoctorLoginBean;
import com.bean.LoginBean;
import com.bean.MedicalInfoBean;
import com.bean.PatientIdBean;
import com.bean.Registrationbean;
import com.bean.DoctorRegistrationBean;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.Part;

public class RegisterDao {
	
	static Connection con;
	
	
	
	public int saveData(Registrationbean reg){
		
		Connection con=MyConnection.con();

		System.out.println("con"+con);

		PreparedStatement ps=null;
		int i=0;
		try {
			
			ps=con.prepareStatement("Insert into HCRegister values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,reg.getRegFname());
			ps.setString(2,reg.getRegMname());
			ps.setString(3,reg.getRegLname());
			ps.setString(4,reg.getDob());
			ps.setString(5,reg.getGender());
			ps.setString(6,reg.getState());
			ps.setString(7, reg.getCity());
			ps.setString(8,reg.getEmail());
			ps.setString(9,reg.getMobno());
			ps.setString(10,reg.getPass());
			ps.setString(11,reg.getImage());
			ps.setString(12,reg.getHealthid());
			i=ps.executeUpdate();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int saveMedicalData(MedicalInfoBean mib){
		
		Connection con=MyConnection.con();
		

		PreparedStatement ps=null;
		int i=0;
		try {
			ps=con.prepareStatement("Insert into medicalinfo values(?,?,?,?,?,?)");
			ps.setString(1,mib.getBg());
			ps.setString(2,mib.getBp());
			ps.setString(3,mib.getHeight());
			ps.setString(4,mib.getWeight());
			ps.setString(5,mib.getAllergies());
			ps.setString(6,mib.getHealthId());
			
			i=ps.executeUpdate();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;		
	}

	public boolean ValidateUser(LoginBean l){
		
		Connection con=MyConnection.con();
		
		boolean b=false;
		PreparedStatement ps=null;

		try {
			ps=con.prepareStatement("select * from hcregister where HEALTHID=? and pass=?");
			ps.setString(1,l.getUsername());
			ps.setString(2,l.getPassword());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
			System.out.println("\nconnection done");
				b=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return b;
	}
	
public boolean ValidateDoctor(DoctorLoginBean l){
		
		Connection con=MyConnection.con();
		
		boolean b=false;
		PreparedStatement ps=null;

		try {
			ps=con.prepareStatement("select * from drregister where License=? and Password=?");
			ps.setString(1,l.getlicense());
			ps.setString(2,l.getPassword());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
			System.out.println("\nconnection done");
				b=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return b;
	}

public boolean ValidatePatientId(PatientIdBean l){
	
	Connection con=MyConnection.con();
	
	boolean b=false;
	PreparedStatement ps=null;

	try {
		ps=con.prepareStatement("select * from hcregister where HEALTHID=?");
		ps.setString(1,l.getId());
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
		System.out.println("\nconnection done");
			b=true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}		
	return b;
}
	
	
	public Registrationbean DisplayUser(String user_name){
		
		Connection con=MyConnection.con();
		
		boolean b=false;
		PreparedStatement ps=null;
		Registrationbean reg=new Registrationbean();
		List<Registrationbean> ls=null;


		try {
			ps=con.prepareStatement("select * from hcregister where HEALTHID=?");
			ps.setString(1,user_name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				reg.setRegFname(rs.getString(1));
				reg.setRegMname(rs.getString(2));
				reg.setRegLname(rs.getString(3));
				reg.setDob(rs.getString(4));
				reg.setGender(rs.getString(5));
				reg.setState(rs.getString(6));
				reg.setCity(rs.getString(7));
				reg.setEmail(rs.getString(8));
				reg.setMobno(rs.getString(9));
				reg.setPass(rs.getString(10));		
				reg.setImage(rs.getString(11));		
				reg.setHealthid(rs.getString(12));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reg;		
	}

public CertificateBean DisplayCertificate(String user_name){
		
		Connection con=MyConnection.con();
		
		boolean b=false;
		PreparedStatement ps=null;
		CertificateBean cer=new CertificateBean();
		


		try {
			ps=con.prepareStatement("select * from certificate where HEALTHID=?");
			ps.setString(1,user_name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				cer.setname(rs.getString(1));
				cer.setdate(rs.getString(2));
				cer.setauthority(rs.getString(3));
				cer.setImage(rs.getString(4));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cer;		
	}
	
	
	public MedicalInfoBean DisplayMedicalInfo(String user_name){
		Connection con=MyConnection.con();
		
		boolean b=false;
		PreparedStatement ps=null;
		MedicalInfoBean mib=new MedicalInfoBean();
		List<MedicalInfoBean> ls=null;

		try {
			ps=con.prepareStatement("select * from medicalinfo where HEALTHID=?");
			ps.setString(1,user_name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				mib.setBg(rs.getString(1));
				mib.setBp(rs.getString(2));
				mib.setHeight(rs.getString(3));
				mib.setWeight(rs.getString(4));
				mib.setAllergies(rs.getString(5));
				mib.setHealthId(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mib;		
	}
	
public int save_disease_Rec_Data(DiseaseBean mb){
		
		Connection con=MyConnection.con();

		PreparedStatement ps=null;
		int i=0;
		try {
			ps=con.prepareStatement("Insert into diseaseinfo values(?,?,?,?,?,?,?,?)");
			ps.setString(1,mb.getDNAME());
			ps.setString(2,mb.getDDATE());
			ps.setString(3,mb.getDSYMP());
			ps.setString(4,mb.getDMED());
			ps.setString(5,mb.getDLOC());
			ps.setString(6,mb.getDHEIR());
			ps.setString(7, mb.getHealthId());
			ps.setString(8, mb.getImage());
			
			i=ps.executeUpdate();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}


public int save_doctor_Rec_Data(DoctorRegistrationBean drobj){
	
	Connection con=MyConnection.con();

	PreparedStatement ps=null;
	int i=0;
	try {
		ps=con.prepareStatement("Insert into drregister values(?,?,?)");
		ps.setString(1,drobj.getlicense());
		ps.setString(2,drobj.getpassword());
		ps.setString(3,drobj.getImage());
		
		i=ps.executeUpdate();
	} catch (NumberFormatException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return i;
}
	
	
public int upload_certificate(CertificateBean cer){
		
		Connection con=MyConnection.con();

		PreparedStatement ps=null;
		int i=0;
		try {
			ps=con.prepareStatement("Insert into certificate values(?,?,?,?,?)");
			ps.setString(1,cer.getname());
			ps.setString(2,cer.getdate());
			ps.setString(3,cer.getauthority());
			ps.setString(4,cer.getImage());
			ps.setString(5,cer.getHealthId());
			
			i=ps.executeUpdate();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	
	public List<DiseaseBean> DisplayDiseaseHistory(String user_name){
		Connection con=MyConnection.con();
		
		
		List<DiseaseBean> dlist=null;
		String str="SELECT * FROM diseaseinfo where HEALTHID='"+user_name+"'";

		try {
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery(str);
			dlist=new LinkedList<DiseaseBean>();
			while(rs.next()){
				DiseaseBean dhistory=new DiseaseBean();
				dhistory.setDNAME(rs.getString(1));
				dhistory.setDDATE(rs.getString(2));
				dhistory.setDSYMP(rs.getString(3));
				dhistory.setDMED(rs.getString(4));
				dhistory.setDLOC(rs.getString(5));
				dhistory.setDHEIR(rs.getString(6));
				dhistory.setHealthId(rs.getString(7));
				dhistory.setImage(rs.getString(8));
				
				dlist.add(dhistory);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dlist;		
	}
	

	public List<CertificateBean> DisplayCertificateHistory(String user_name){
		Connection con=MyConnection.con();
		
		
		List<CertificateBean> dlist=null;
		String str="SELECT * FROM certificate where HEALTHID='"+user_name+"'";

		try {
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery(str);
			dlist=new LinkedList<CertificateBean>();
			while(rs.next()){
				CertificateBean dhistory=new CertificateBean();
				dhistory.setname(rs.getString(1));
				dhistory.setdate(rs.getString(2));
				dhistory.setauthority(rs.getString(3));
				dhistory.setImage(rs.getString(4));
				dlist.add(dhistory);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dlist;		
	}

	
	/*
	public DiseaseBean DisplayDiseaseHistory(String user_name){
		boolean b=false;
		PreparedStatement ps=null;
		DiseaseBean dhistory=new DiseaseBean();
		List<DiseaseBean> ls=null;
		con=MyConnection.getConnection();
		try {
			ps=con.prepareStatement("select * from diseaseinfo where demail=?");
			ps.setString(1,user_name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				dhistory.setDNAME(rs.getString(1));
				dhistory.setDDATE(rs.getString(2));
				dhistory.setDSYMP(rs.getString(3));
				dhistory.setDMED(rs.getString(4));
				dhistory.setDLOC(rs.getString(5));
				dhistory.setDHEIR(rs.getString(6));
				dhistory.setDEMAIL(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dhistory;		
	}
	*/
	public int UpdateMedicalInfo(MedicalInfoBean mib){
		Connection con=MyConnection.con();
		
		System.out.println("In rd mb: "+mib.getHealthId());

		PreparedStatement ps=null;
		int i=0;		
		try {
			ps=con.prepareStatement("update medicalinfo set bloodgroup = ?, bpgroup = ?, height = ?, weight = ?, allergies = ? where HEALTHID = ?");			
			ps.setString(1,mib.getBg());
			ps.setString(2,mib.getBp());
			ps.setString(3,mib.getHeight());
			ps.setString(4,mib.getWeight());
			ps.setString(5,mib.getAllergies());
			ps.setString(6,mib.getHealthId());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return i;
	}

}