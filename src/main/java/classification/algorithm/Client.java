package classification.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * k最近邻算法场景类型
 * 
 * @author lyq
 *
 */
public class Client {
  public static void main(String[] args) {
    String trainDataPath = "C:\\Users\\shinelon\\IdeaProjects\\datamining\\src\\main\\java\\classification\\data\\trainInput.txt";
    String testDataPath = "C:\\Users\\shinelon\\IdeaProjects\\datamining\\src\\main\\java\\classification\\data\\testInput.txt";

    KNNTool tool = new KNNTool(trainDataPath, testDataPath);
    tool.knnCompute(3);

  }

}
