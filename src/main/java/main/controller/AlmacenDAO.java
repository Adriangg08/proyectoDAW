package main.controller;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import main.model.Almacen;
import main.util.JPAUtil;

public class AlmacenDAO {

	public void insertarAlmacenJPA(Almacen almacen) {
		 
		 EntityManager em =  JPAUtil.getEntityManagerFactory().createEntityManager();
		 
		 try {
			em.getTransaction().begin();
			em.persist(almacen);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
		 
	 }
	 
	 public void modificarAlmacenJPA (Almacen almacen) {
		
		 EntityManager em =  JPAUtil.getEntityManagerFactory().createEntityManager();
		 
		 try {
			em.getTransaction().begin();
			em.merge(almacen);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.err.println(e.getMessage());
		} finally {
			em.close();
		} 
	 }

	 public void eliminarAlmacenJPA (Almacen almacen) {

		 EntityManager em =  JPAUtil.getEntityManagerFactory().createEntityManager();
		 
		 try {
			Almacen a = em.find(Almacen.class, almacen.getId());
			em.getTransaction().begin();
			em.remove(a);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.err.println(e.getMessage());
		} finally {
			em.close();
		} 
	 }
	 
	 public ArrayList<Almacen> listarAlmacensJPA () {
		
		 EntityManager em =  JPAUtil.getEntityManagerFactory().createEntityManager();
		 
		 try {
			em.getTransaction().begin();
			ArrayList<Almacen> listaAlmacens = (ArrayList<Almacen>) em.createQuery("from Almacen").getResultList();
			em.getTransaction().commit();
			return listaAlmacens;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.err.println(e.getMessage());
		} finally {
			em.close();
		} 
		 
		 return null;
	 }
	 
	 public void imprimirAlmacens(ArrayList<Almacen> listaAlmacens) {
		 
		 for (Almacen a: listaAlmacens) {
			 a.imprimir();
		 }
	 } 
	 
	 public Almacen buscarIDJPA(int id) {
	        EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	        try {
	            entity.getTransaction().begin();
	            Almacen almacen = entity.find(Almacen.class, id);
	            entity.getTransaction().commit();
	            System.out.println("El almacen del id " +id+ " es " +almacen.getNombre());
	            return almacen;
	        } catch (PersistenceException exception) {
	            entity.getTransaction().rollback();
	            System.out.println(exception.getMessage());
	        } finally {
	            entity.close();
	        }
	        return null;    
	    }

}
