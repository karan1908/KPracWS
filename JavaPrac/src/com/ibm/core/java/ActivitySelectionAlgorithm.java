package com.ibm.core.java;

import java.util.Arrays;

public class ActivitySelectionAlgorithm {

	class Movie implements Comparable<Movie>
	{
		int startTime;
		int endTime;
		String name;

		Movie(int startTime,int endTime,String name)
		{
			this.startTime = startTime;
			this.endTime = endTime;
			this.name = name;
		}

		@Override
		public int compareTo(Movie compareMovie) {

			int compareEndTime = ((Movie) compareMovie).endTime;

			//ascending order
			return this.endTime - compareEndTime;
		}

		@Override
		public String toString() {
			return name;
		}

	}//Movie

	void printAllMovies(Movie[] movies)
	{
		for(ActivitySelectionAlgorithm.Movie movie:movies)
		{
			System.out.print(movie+" ");
		}
	}
	
	void printSelectedMovies(Movie[] movies)
	{
		int selectedMovie=0;
		System.out.print(movies[selectedMovie].name+" ");
		for(int i=1;i<movies.length;++i)
		{
			if(movies[i].startTime >= movies[selectedMovie].endTime)
			{
				selectedMovie = i;
				System.out.print(movies[selectedMovie].name+" ");
			}
		}
	}

	public static void main(String[] args) {
		ActivitySelectionAlgorithm asa = new ActivitySelectionAlgorithm();
		ActivitySelectionAlgorithm.Movie[] movies = new ActivitySelectionAlgorithm.Movie[6];
		movies[0] = asa.new Movie(1,4,"A");
		movies[1] = asa.new Movie(6,9,"B");
		movies[2] = asa.new Movie(7,10,"C");
		movies[3] = asa.new Movie(6,7,"D");
		movies[4] = asa.new Movie(8,9,"E");
		movies[5] = asa.new Movie(0,1,"F");

		System.out.println("Movies Unsorted");
		asa.printAllMovies(movies);

		Arrays.sort(movies);
		System.out.println("\nMovies Sorted as per End Time");
		asa.printAllMovies(movies);

		System.out.println("\nSelected Movies");
		asa.printSelectedMovies(movies);

	}

}
