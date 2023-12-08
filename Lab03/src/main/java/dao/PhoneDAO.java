package org.example.dao;

import jakarta.persistence.Query;
import org.example.Domain.Manufacture;
import org.example.Domain.Phone;
import org.example.repository.Repository;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class PhoneDAO implements Repository<Phone, Integer>{
    public static final Session session;

    static {
        session = HibernateUtil.getFactory().openSession();
    }

    public PhoneDAO() {
    }

    @Override
    public boolean add(Phone phone) {
        try {
            session.beginTransaction();
            session.save(phone);
            session.getTransaction().commit();
            //System.out.println("Phone"+ ((Phone)phone).getName() + " added");
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Phone get(Integer id) {
        try {
            Phone p = session.find(Phone.class, id);
            return p;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Phone> getAll() {
        List<Phone> list = null;
        try {
            list = session.createQuery("FROM Phone", Phone.class).list();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean remove(int id) {

        try {
            session.beginTransaction();
            Phone p = session.find(Phone.class, id);
            if(p!=null){
                session.delete(p);
            }
            session.getTransaction().commit();
            //session.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();

        }

        return false;
    }

    @Override
    public boolean remove(Phone phone) {
        try {
            session.beginTransaction();
            session.delete(phone);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Phone phone) {
        try {
            session.beginTransaction();
            session.update(phone);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Phone getHighestSellingPrice(){
        Phone p = null;
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Phone order by price desc");
            query.setMaxResults(1);
            p = (Phone) query.getSingleResult();
            session.getTransaction().commit();
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return p;
    }

    public List<Phone> getListPhoneByCountryAndPrice(){
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Phone order by country desc, price desc");

            List<Phone> listPhone = query.getResultList();
            session.getTransaction().commit();
            return listPhone;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean getPhonePriceThan50(Phone phone){
        return phone.getPrice() >5000000;
    }

    public Phone getPhonePinkColorAndPriceThan15(){
        try {
            session.beginTransaction();

            Query qr = session.createQuery("from Phone where color like :color and price > :price");
            qr.setParameter("color", "%pink%");
            qr.setParameter("price", 1500000);
            Phone p = (Phone) qr.getSingleResult();
            session.getTransaction().commit();
            return p;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
