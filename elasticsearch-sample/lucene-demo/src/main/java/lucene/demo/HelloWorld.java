package lucene.demo;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.nio.file.Paths;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/4
 */
public class HelloWorld {

    @Test
    public void testCreate() throws Exception{
        Article article = new Article();
        article.setId(108L);
        article.setAuthor("老王");
        article.setTitle("学习大数据");
        article.setContent("学数据，迎娶丁老师！");
        article.setUrl("http://www.edu360.cn/a10011");

        String indexPath = "D:\\GitHub\\j2ee-sample\\elasticsearch-sample\\storage\\lucene\\index";
        FSDirectory fsDirectory = FSDirectory.open(Paths.get(indexPath));
        //创建一个标准分词器，一个字分一次
        Analyzer analyzer = new StandardAnalyzer();
//        Analyzer analyzer = new IKAnalyzer(true);
        //写入索引的配置，设置了分词器
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        //指定了写入数据目录和配置
        IndexWriter indexWriter = new IndexWriter(fsDirectory, indexWriterConfig);
        //创建一个文档对象
        Document document = article.toDocument();
        //通过IndexWriter写入
        indexWriter.addDocument(document);
        indexWriter.close();
    }

    @Test
    public void testQueryParser() throws Exception{
        String indexPath="D:\\GitHub\\j2ee-sample\\elasticsearch-sample\\storage";
        DirectoryReader directoryReader;
//        directoryReader = DirectoryReader.o(indexPath);

    }
}
