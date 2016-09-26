package ml.classifiers;

import java.util.ArrayList;

import ml.data.DataSet;
import ml.data.Example;

public class KNNClassifier implements Classifier {

	private int k = 3;

	public static void main(String[] args) {
		// TODO DELETE

	}

	@Override
	public void train(DataSet data) {
		ArrayList<Example> examples = data.getData();

		for (int i = 0; i < examples.size() - 1; i++) {
			ArrayList<Double> distances = getDistance(examples, i);
			double majLabel = findMajority(distances);

		}

	}

	private ArrayList<Double> getDistance(ArrayList<Example> examples, int index) {
		ArrayList<Double> nearestNeighbors = new ArrayList<Double>();

		double sum = 0;
		int size = examples.get(0).getFeatureSet().size();

		for (Example example : examples) {
			for (int i = 0; i < size; i++) {
				// get (a-b)^2
				double diff = example.getFeature(index) - example.getFeature(i);
				sum += Math.pow(diff, 2.0);
			}
			nearestNeighbors.add(Math.pow(sum, 0.5)); // add square root
		}

		// TODO we have to find the k smallest distances and only return those
		return nearestNeighbors;

	}

	private double findMajority(ArrayList<Double> distances) {

		return 0.0;

	}

	@Override
	public double classify(Example example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setK(int k) {
		this.k = k;
	}

}
