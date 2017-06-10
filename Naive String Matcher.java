package selim;
public class project4 {


	public static void main(String[] args) {

		String text = "one of the earliest systems of writing, was invented by the sumerians the";
		String pattern = "the";

		char cText []= text.toCharArray();
		char cPattern [] = pattern.toCharArray();

		boolean correction [] [] = new boolean[cText.length][cPattern.length];

		for (int i = 0; i <= (cText.length-cPattern.length); i++) {

			for (int j = 0; j < cPattern.length; j++) {

				if(cText[i+j] == cPattern[j]){
					correction[i][j] = true;
				}

				else
					correction[i][j] = false;

			}
		}

		int occurens=0;

		for (int i = 0; i < (cText.length); i++) {

			int x = 0;

			for (int j = 0; j < cPattern.length; j++) {

				if(correction[i][j]){
					x++;
					if(x == cPattern.length){
						occurens++;
						System.out.println("Shift Position: "+i);
					}
				}
			}
		}
		System.out.println(occurens + " pattern occurrences were detected");
	}
}
