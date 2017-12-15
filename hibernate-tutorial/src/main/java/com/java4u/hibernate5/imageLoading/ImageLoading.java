package com.java4u.hibernate5.imageLoading;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java4u.hibernate5.model.Product;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class ImageLoading {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtilMySql.getSessionFactory().openSession();
			transaction = session.getTransaction();
			transaction.begin();

			Product product = session.get(Product.class, 1L);
			System.out.println("Product Name: " + product.getName());

			InputStream imageStream = product.getImage().getBinaryStream();
			saveImage(imageStream);
			transaction.commit();

			System.out.println("Product is saved successfully.");

		} catch (Exception e) {
			if (transaction != null) {
				System.out.println("Transaction is being rolled back.");
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	private static void saveImage(InputStream imageStream) {
		File file = new File("ouput.png");
		try (FileOutputStream outputStream = new FileOutputStream(file)) {
			 BufferedImage bufferedImage = ImageIO.read(imageStream);
	         ImageIO.write(bufferedImage, "png", outputStream);
	         System.out.println("Image file location: "+file.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
