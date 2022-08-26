static int[][] deepcopy(int[][] origin){
		int[][] copy = new int[origin.length][origin[0].length];
		
		for (int i = 0; i < origin.length; i++) {
			for (int j = 0; j < origin[0].length; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		
		return copy;
	}