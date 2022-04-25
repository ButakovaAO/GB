package MiniMarket.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyCategoryTest {

    public static void main( String[] args ) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        db.dao.CategoriesMapper categoriesMapper = session.getMapper(db.dao.CategoriesMapper.class);
        db.model.CategoriesExample example = new db.model.CategoriesExample();
        example.createCriteria().andIdEqualTo(2);
        List<db.model.Categories> list = categoriesMapper.selectByExample(example);
        System.out.println(categoriesMapper.countByExample(example));

        db.model.Categories categories = new db.model.Categories();
        categories.setTitle("Sea food");
        categoriesMapper.insert(categories);
        session.commit();
        System.out.println(categoriesMapper.countByExample(example));

        db.model.CategoriesExample example2 = new db.model.CategoriesExample();
        example2.createCriteria().andTitleLike("Sea food");
        List<db.model.Categories> list2 = categoriesMapper.selectByExample(example2);
        db.model.Categories categories2 = list2.get(0);
        categories2.setTitle("Seafood");
        categoriesMapper.updateByPrimaryKey(categories2);
        session.commit();
        System.out.println(categoriesMapper.countByExample(example));

        categoriesMapper.deleteByPrimaryKey(categories2.getId());
        session.commit();
        System.out.println(categoriesMapper.countByExample(example2));

        session.close();

    }
}
