package thread;

import java.util.Scanner;

public class thread {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Enter Start and end values ti iterate ");
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			Thread odd = new Thread(new Runnable() {

				@Override
				public void run() {
					for (int i = start; i <= end; i++) {
						if (i % 2 != 0)
							System.out.println("Odd " + i);
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
						}
					}

				}
			});

			Thread even = new Thread(new Runnable() {

				@Override
				public void run() {
					for (int i = start; i <= end; i++) {
						if (i % 2 == 0) {
							System.out.println("Even " + i);
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
							}
						}
					}

				}
			});

			even.start();
			odd.start();
			even.join();
			odd.join();
			System.out.println("Main over");
		} catch (Exception e) {
			System.out.println("you did not enter int value");
			;
		}

	}

}
