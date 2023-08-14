package weka;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.Evaluation;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class ModelEvaluation {

  public static void main(String[] args) throws Exception {
    // Load dataset
    DataSource source = new DataSource("src/main/java/weka/heart.arff");
    Instances dataset = source.getDataSet();
    dataset.setClassIndex(dataset.numAttributes() - 1);

    // Build a model
    NaiveBayes classifier = new NaiveBayes();
    classifier.buildClassifier(dataset);

    // Evaluate model
    Evaluation evaluation = new Evaluation(dataset);
    evaluation.evaluateModel(classifier, dataset);

    System.out.println(evaluation.toSummaryString());
  }
}
