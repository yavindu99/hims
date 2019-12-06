package hims.version1.service;

import hims.common.ClientMessages;
import hims.common.CustomException;
import hims.common.CustomResponseMainBody;
import hims.version1.dao.PatientDAOInt;
import hims.version1.entity.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientServiceInt {

    private PatientDAOInt dao;

    private HttpStatus httpStatusCode;
    private String msgCode;
    private String msg;

    private SessionFactory sessionFactory;
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public PatientServiceImpl(PatientDAOInt dao,EntityManagerFactory entityManagerFactory) {

        this.entityManagerFactory = entityManagerFactory;
        this.dao = dao;

        sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }

    @Override
    public CustomResponseMainBody getListBySearchCriteria(Pageable pageable,String patientLegalId,String patientName,String patientAddressDistrict) {

        Session session = null;
        Transaction transaction = null;
        List<Patient> patientList = new ArrayList<>();

        try{

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
            this.msg = "version1_patient_list_found";

            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            String sqlStr =

                    "SELECT * FROM " +
                    " ( " +

                    " SELECT pd.patientID,pd.patientName " +
                    " FROM patientdemographic pd "+
                    " WHERE ";

            if(patientLegalId != "") {

                sqlStr +=
                        " patientID='" + patientLegalId + "'" +
                        " OR patientNIC='" + patientLegalId + "'";
            }

            if(patientLegalId == "" && (patientName != "" || patientAddressDistrict != "")) {

                sqlStr +=
                        " patientName='" + patientName + "'" +
                        " OR patientAddressDistrict='" + patientAddressDistrict + "'";
            }

            sqlStr +=
                    " UNION " +

                    " SELECT pd.patientID,pd.patientName " +
                    " FROM clinicadmission ca " +
                    " INNER JOIN patientdemographic pd ON pd.patientID=ca.patientID " +
                    " WHERE BHTClinicFileNo='"+patientLegalId+"'" +

                    " UNION " +

                    " SELECT pd.patientID,pd.patientName" +
                    " FROM admission a INNER JOIN patientdemographic pd ON pd.patientID=a.patientID " +
                    " WHERE BHTClinicFileNo='"+patientLegalId+"' " +

                    " )asd ";

            if(patientName != "" && patientAddressDistrict != "") {

                sqlStr +=
                        " WHERE " +
                        " patientName='" + patientName + "'"+
                        " AND patientAddressDistrict='" + patientAddressDistrict + "'";

            }

            if(patientName != "" && patientAddressDistrict == "") {

                sqlStr += " WHERE patientName='" + patientName + "'";

            }

            if(patientName == "" && patientAddressDistrict != "") {

                sqlStr += " WHERE patientAddressDistrict='" + patientAddressDistrict + "'";

            }

            sqlStr += " ORDER BY asd.patientName";

            patientList = session.createNativeQuery(sqlStr).list();

            transaction.commit();

            if (patientList.size() == 0) {

                this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
                this.msg = "no_version1_patient_found";

            }

        }catch (Exception e) {

            transaction.rollback();
            e.printStackTrace();

        } finally {

            if (session != null) {

                session.close();

            }
        }

//        Page<Patient> page = hims.version2.dao.getListBySearchCriteria(pageable,patientId);
//        long len = page.get().count();
//
//        if (len == 0) {
//
//            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
//            this.msg = "no_version1_patient_found";
//        }


        CustomResponseMainBody<List<Patient>> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, patientList);

        return mainBody;


    }

    @Override
    public CustomResponseMainBody getByPatientId(String patientId) {

        Patient patient = null;

        try {

            patient = dao.getByPatientId(patientId);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
            this.msg = "version1_patient_found";

        } catch (CustomException ex) {

            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
            this.msg = "no_version1_patient_found";
        }

        CustomResponseMainBody<Patient> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, patient);

        return mainBody;
    }
}
