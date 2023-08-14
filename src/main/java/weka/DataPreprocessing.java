package weka;

import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.supervised.attribute.Discretize;
import weka.filters.unsupervised.attribute.Normalize;

import static weka.core.converters.ConverterUtils.DataSource;

public class DataPreprocessing {

  public static void main(String[] args) throws Exception {
    // Load dataset
    DataSource source = new DataSource("src/main/java/weka/diabetes.arff");
    Instances dataset = source.getDataSet();
    dataset.setClassIndex(dataset.numAttributes() - 1);

    // Normalize data
    Normalize normalize = new Normalize();
    normalize.setInputFormat(dataset);
    Instances normalizedDataset = Filter.useFilter(dataset, normalize);

    // Discretize data
    Discretize discretize = new Discretize();
    discretize.setInputFormat(normalizedDataset);
    Instances discretizedDataset = Filter.useFilter(normalizedDataset, discretize);

    System.out.println(discretizedDataset);
  }
}
