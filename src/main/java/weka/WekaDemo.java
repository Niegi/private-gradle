package weka;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;

import static weka.core.converters.ConverterUtils.DataSource;

public class WekaDemo {

  public static void main(String[] args) throws Exception {
    // Load dataset
    DataSource source = new DataSource("src/main/java/weka/iris.arff");
    Instances dataset = source.getDataSet();
    dataset.setClassIndex(dataset.numAttributes() - 1);

    // Build and evaluate a model
    NaiveBayes classifier = new NaiveBayes();
    classifier.buildClassifier(dataset);

    // Print model summary
    System.out.println(classifier);
  }
}
