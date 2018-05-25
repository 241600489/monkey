package com.zym.monkey.yaml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.TreeNode;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author 梁自强
 * @date 2018/5/25 15:56
 * @desc 测试读取yaml 文件
 */
public class TestReadYamFile {
    private static final Logger logger = LoggerFactory.getLogger(TestReadYamFile.class);
    //E:\myself\monkey\monkey-default.yml
    public static final String DEFAULT_DIR = "\\src\\main\\resources\\";
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Test
    public void testRead() {
        try {
            YAMLParser yamlParser = new YAMLFactory().createParser(new File(System.getProperty("user.dir") +
                    File.separator + DEFAULT_DIR + "monkey-default.yml"));
            logger.info("text:" + yamlParser.getText());
            logger.info("currentName:" + yamlParser.getCurrentName());
            logger.info("enbedded:" + yamlParser.getEmbeddedObject());
            logger.info("typeId:" + yamlParser.getTypeId());
            JsonNode jsonNode = OBJECT_MAPPER.readTree(yamlParser);
            logger.info("jsonNode text" + jsonNode.asText());
            TreeTraversingParser treeTraversingParser = new TreeTraversingParser(jsonNode);
            HashMap map = OBJECT_MAPPER.readValue(treeTraversingParser, HashMap.class);

            System.out.println(map.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
