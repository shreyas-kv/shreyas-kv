package com.niit.shreyasmobilesBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shreyasmobilesBackend.Dao.AuthenticationDao;
import com.niit.shreyasmobilesBackend.Dao.BillingAddressDao;
import com.niit.shreyasmobilesBackend.Dao.CardDao;
import com.niit.shreyasmobilesBackend.Dao.CartDao;
import com.niit.shreyasmobilesBackend.Dao.CartItemsDao;
import com.niit.shreyasmobilesBackend.Dao.CategoryDao;
import com.niit.shreyasmobilesBackend.Dao.OrderDao;
import com.niit.shreyasmobilesBackend.Dao.OrderItemsDao;
import com.niit.shreyasmobilesBackend.Dao.PayDao;
import com.niit.shreyasmobilesBackend.Dao.ProductDao;
import com.niit.shreyasmobilesBackend.Dao.ShippingAddressDao;
import com.niit.shreyasmobilesBackend.Dao.SupplierDao;
import com.niit.shreyasmobilesBackend.Dao.UserDao;
import com.niit.shreyasmobilesBackend.DaoImpl.AuthenticationDaoImpl;
import com.niit.shreyasmobilesBackend.DaoImpl.BillingAddressDaoImpl;
import com.niit.shreyasmobilesBackend.DaoImpl.CardDaoImpl;
import com.niit.shreyasmobilesBackend.DaoImpl.CartDaoImpl;
import com.niit.shreyasmobilesBackend.DaoImpl.CartItemsDaoImpl;
import com.niit.shreyasmobilesBackend.DaoImpl.CategoryDaoImpl;
import com.niit.shreyasmobilesBackend.DaoImpl.OrderDaoImpl;
import com.niit.shreyasmobilesBackend.DaoImpl.OrderItemsDaoImpl;
import com.niit.shreyasmobilesBackend.DaoImpl.PayDaoImpl;
import com.niit.shreyasmobilesBackend.DaoImpl.ProductDaoImpl;
import com.niit.shreyasmobilesBackend.DaoImpl.ShippingAddressDaoImpl;
import com.niit.shreyasmobilesBackend.DaoImpl.SupplierDaoImpl;
import com.niit.shreyasmobilesBackend.DaoImpl.UserDaoImpl;
import com.niit.shreyasmobilesBackend.model.Authentication;
import com.niit.shreyasmobilesBackend.model.BillingAddress;
import com.niit.shreyasmobilesBackend.model.Card;
import com.niit.shreyasmobilesBackend.model.Cart;
import com.niit.shreyasmobilesBackend.model.CartItems;
import com.niit.shreyasmobilesBackend.model.Category;
import com.niit.shreyasmobilesBackend.model.Order;
import com.niit.shreyasmobilesBackend.model.OrderItems;
import com.niit.shreyasmobilesBackend.model.Pay;
import com.niit.shreyasmobilesBackend.model.Product;
import com.niit.shreyasmobilesBackend.model.ShippingAddress;
import com.niit.shreyasmobilesBackend.model.Supplier;
import com.niit.shreyasmobilesBackend.model.User;


@Configuration  //makes java class files as a configuration files (Translate itself to xml file)
@ComponentScan("com.niit.*")   //search methods in package given (pick ups all classes n methods and becomes ready to use
@EnableTransactionManagement 


public class ApplicationContext 
{
	@Bean("dataSource")  //create a object without new keyword 
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		
//		Properties connectionProperties=new Properties();
//		connectionProperties.setProperty("hibernate.connection.pool_size", "10");
//		connectionProperties.setProperty("hibernate.hbm2ddl.auto", "update");
//		connectionProperties.setProperty("hibernate.show_sql", "true");
//		connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect");
	return dataSource;
	}
	private Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.put("hibernate.connection.pool_size", "10"); //size in which it can execute
		properties.put("hibernate.hbm2ddl.auto", "update"); //to update the table rather than dropping and creating
		properties.put("hibernate.show_sql","true"); //Responsible to show query in console
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect"); //type of Database
		return properties;
	}
	
	@Autowired   //link two methods having same name
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(BillingAddress.class);
		sessionBuilder.addAnnotatedClass(ShippingAddress.class);
		sessionBuilder.addAnnotatedClass(Pay.class);
		sessionBuilder.addAnnotatedClass(Card.class);
		sessionBuilder.addAnnotatedClass(CartItems.class);
		sessionBuilder.addAnnotatedClass(Authentication.class);
		sessionBuilder.addAnnotatedClass(Order.class);
		sessionBuilder.addAnnotatedClass(OrderItems.class);
		
		
		// sessionBuilder.buildMapping(net.viralpatel.hibernate.UserDetails2);
		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean("transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	@Autowired
	@Bean("categoryDao")
	public CategoryDao getCategoryDao(SessionFactory sessionFactory)
	{
		return new CategoryDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("supplierDao")
	public SupplierDao getSupplierDao(SessionFactory sessionFactory)
	{
		return new SupplierDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("productDao")
	public ProductDao getProductDao(SessionFactory sessionFactory)
	{
		return new ProductDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("userDao")
	public UserDao getUserDao(SessionFactory sessionFactory)
	{
		return new UserDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("cartDao")
	public CartDao getCartDao(SessionFactory sessionFactory)
	{
		return new CartDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("billingaddressDao")
	public BillingAddressDao getbillingaddressdao(SessionFactory sessionFactory)
	{
		return new BillingAddressDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("shippingaddressDao")
	public ShippingAddressDao getshippingaddressdao(SessionFactory sessionFactory)
	{
		return new ShippingAddressDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("payDao")
	public PayDao getpaydao(SessionFactory sessionFactory)
	{
		return new PayDaoImpl(sessionFactory);
		
	}
	
	@Autowired
	@Bean("cardDao")
	public CardDao getcarddao(SessionFactory sessionFactory)
	{
		return new CardDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("cartItemsDao")
	public CartItemsDao getcartitemdao(SessionFactory sessionFactory)
	{
		return new CartItemsDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("authenticationDao")
	public AuthenticationDao getauthenticationdao(SessionFactory sessionFactory)
	{
		return new AuthenticationDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("orderDao")
	public OrderDao getorderdao(SessionFactory sessionFactory)
	{
		return new OrderDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("orderItemsDao")
	public OrderItemsDao getorderitemsdao(SessionFactory sessionFactory)
	{
		return new OrderItemsDaoImpl(sessionFactory);
	}
}
