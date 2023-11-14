//import java.util.ArrayList;
//
//public class QuestionBank {
//	ArrayList<Question> bank;
//	/* index 0-2 beginnerDM
//	 * index 3-5 intermediateDM
//	 * index 6-8 expertDM
//	 *
//	 * index 9-11 beginner CSci
//	 * index 12-14 intermediate CSci
//	 * index 15-17 expert CSci
//	 *
//	 * index 18-20 beginner COrg
//	 * index 21-23 intermediate COrg
//	 * index 24-26 expert COrg
//	 *
//	 */
//	public static void main(String[] args) {
//		QuestionBank bank = new QuestionBank();
//	}
//	public QuestionBank() {
//		bank = new ArrayList<Question>();
//
//		String[] answers = new String[4];
//		answers[0] = "The empty set is always a subset of every set.";
//		answers[1] = "The empty set is never a subset of any set.";
//		answers[2] = "The empty set is a subset of finite sets only.";
//		answers[3] = "The empty set is a subset of some, but not all, sets.";
//		Question question1 = new Question("Which statement best describes the concept of the empty set's relationship to other sets?", answers, 1 );
//		bank.add(question1);
//
//		answers = new String[4];
//		answers[0] = "Discrete Mathematics studies countable or discrete mathematical structures.";
//		answers[1] = "It focuses on the study of prime numbers exclusively.";
//		answers[2] = "It studies all mathematical structures, including continuous ones.";
//		answers[3] = "Discrete Mathematics primarily deals with irrational numbers.";
//		Question question2 = new Question("What is the central idea behind Discrete Mathematics?", answers, 1);
//		bank.add(question2);
//
//		answers = new String[4];
//		answers[0] = "By assuming the statement is true.";
//		answers[1] = "By disproving the statement with counterexamples.";
//		answers[2] = "By starting with the negation of the statement.";
//		answers[3] = "By assuming a completely unrelated statement.";
//		Question question3 = new Question("How does a direct proof typically begin when proving a statement?", answers, 1);
//		bank.add(question3);
//
//		answers = new String[4];
//		answers[0] = "It means p is equivalent to q.";
//		answers[1] = "It means q if and only if p.";
//		answers[2] = "It means either p or q is true.";
//		answers[3] = "It means p is true, and q is false.";
//		Question question4 = new Question("What does the statement \"p <-> q\" represent in logic?", answers, 2);
//		bank.add(question4);
//
//		answers = new String[4];
//		answers[0] = "It's used to prove statements for all positive integers.";
//		answers[1] = "It's used to disprove statements for all positive integers.";
//		answers[2] = "It's used only for negative integers.";
//		answers[3] = "It's used to prove statements for all real numbers.";
//		Question question5 = new Question("How is mathematical induction primarily used in mathematics?", answers, 2);
//		bank.add(question5);
//
//		answers = new String[4];
//		answers[0] = "It means if p, then q.";
//		answers[1] = "It means q is equivalent to p.";
//		answers[2] = "It means q if and only if p.";
//		answers[3] = "It means either p or q is true.";
//		Question question6 = new Question("What is the meaning of the statement \"p -> q\" in logic?", answers, 2);
//		bank.add(question6);
//
//
//
//		for (int j = 0; j < 6; j++) {
//			System.out.println("Question "+(j+1)+": "+bank.get(j).questionText);
//			for(int i = 0; i < bank.get(i).answers.length; i++) {
//				System.out.println(bank.get(j).answers[i]);
//			}
//			System.out.println();
//		}
//
//
//
//		// read in questions - some sort of loop to add each question to the arraylist
//	}
//}
