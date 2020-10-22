
package mz.co.scn.inventory.test;


import org.hibernate.Session;

import mz.co.scn.inventory.model.brand.Brand;
import mz.co.scn.inventory.model.brand.BrandDAO;
import mz.co.scn.inventory.util.HibernateUtil;

/**
 *
 * @author Sidónio Goenha on Aug 27, 2020
 *
 */
public class Main {
	private BrandDAO brandDAO;
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		
		Brand brand = new Brand("Teste", "Dados de Teste");
		
		session.save(brand);
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		
		System.out.println("Saved: " + brand.toString());
		
	}
	
	public static void create() {
		
	}

}
