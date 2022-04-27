package MiniMarket.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyProductsTest {

    public static void main( String[] args ) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        db.dao.ProductsMapper productsMapper = session.getMapper(db.dao.ProductsMapper.class);
        db.model.ProductsExample example = new db.model.ProductsExample();
        example.createCriteria().andIdEqualTo(2L);
        List<db.model.Products> list = productsMapper.selectByExample(example);
        System.out.println(productsMapper.countByExample(example));

        db.model.Products products = new db.model.Products();
        products.setTitle("squid");
        productsMapper.insert(products);
        session.commit();
        System.out.println(productsMapper.countByExample(example));

        db.model.ProductsExample example2 = new db.model.ProductsExample();
        example2.createCriteria().andTitleLike("squid");
        List<db.model.Products> list2 = productsMapper.selectByExample(example2);
        db.model.Products products2 = list2.get(0);
        products2.setTitle("squid1");
        productsMapper.updateByPrimaryKey(products2);
        session.commit();
        System.out.println(productsMapper.countByExample(example));

        productsMapper.deleteByPrimaryKey(products2.getId());
        session.commit();
        System.out.println(productsMapper.countByExample(example2));

        session.close();

    }
}
