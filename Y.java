package r;
import java.util.*;

import java.util.Random;

import java.util.Scanner;

import java.util.Stack;

class Word_Guess {
	 int score;
	static int wordIndex=0;

Word_Guess(){
score=0;
rules1();
		
}

 public void word_guess() {

Scanner scanner = new Scanner(System.in);

 // Words to be guessed

String[] words= {"Quicksort","array" ,"object","abstraction","encapsulation","stack","queue","inheritance"};
//Hints
String[] hint= {"Most Efficient Sorting Algorithm","Data structure for storing  elements of same data type only","Instance of class","Hiding implementation details","Uses public getter and setter method to access private data","Used for DFS traversal","Used for BFS traversal","Designing new class from already existing class"};
Random random =new Random();
//RandomIndex will be assigned
int randomIndex=random.nextInt(words.length);

int e;
 
  // Creating stack to store guess letters
Stack<Character> guessed = new Stack<>();

  // Maximum incorrect gueeses here are 4 which means player have 4 chances which may be incorrect letter.
int maxIncorrectGuesses = 4;
 //Traversing till last word in words array

while (randomIndex < words.length) {
//wordToGuess is a  variable which is used to access words present in words array
int i;
do {
System.out.println("Let's find the word!!\n");

 String wordToGuess = words[randomIndex].toLowerCase();
 String h2=hint[randomIndex];
 //To store length of word

int wordLength = wordToGuess.length();
int incorrectGuesses = 0;


System.out.println("Word " + (wordIndex+1) + ":");
while (incorrectGuesses < maxIncorrectGuesses) {
// Display the current state of the word
	
	System.out.println("Hint:"+h2);
	System.out.println();
for (i = 0; i < wordLength; i++) {

char letter = wordToGuess.charAt(i);
 //Checking if stack guess contain any letter
if (guessed.contains(letter)) {
 System.out.print(letter + " ");

 //If not then print dash 
 } else {
 System.out.print(" _ ");

 }
  }
 System.out.println();

// Display guessed letters
String input;
System.out.print("Guessed letters:" + guessed+"\n");

// Ask user to enter letter

 System.out.print("\nGuess a letter: \n");
 input = scanner.nextLine();
 
 // Check if the input is a single letter
 if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
System.out.println("Please enter a single letter.");
   continue;

  }
  char guess = input.toLowerCase().charAt(0);


   // Check if the letter has already been guessed i.e.already present in stack 

if (guessed.contains(guess)) {
//If user enters letter which is already guessed
   System.out.println("You've already guessed that letter.\n");
      
continue;

    }

     // Add the letter to the guessed  stack

 guessed.push(guess);

    // Check if the letter is in the word to guess

  if (!wordToGuess.contains(String.valueOf(guess))) {
    	 
  incorrectGuesses++;

   System.out.println("Incorrect guess. Last " + (maxIncorrectGuesses - incorrectGuesses) + " chance left.");
 
   
 }
// Check if the word has been completely guessed
  boolean wordGuessed = true;//If stack doesn't contain any character from given word or checks if a character is a space then mark it as false
  for ( i = 0; i < wordLength; i++) {
  if (!guessed.contains(wordToGuess.charAt(i)) && wordToGuess.charAt(i) != ' ') {
  wordGuessed = false;

 break;
 }
 }
 if (wordGuessed) {
 System.out.println("Congratulations! You've guessed the word: " + wordToGuess+"\n");
 score=score+10;
 
 break;
    }
   }

// If the player runs out of guesses, reveal the word
if (incorrectGuesses == maxIncorrectGuesses) {
  System.out.println("You've exceeded guessing limit. The word was: " + wordToGuess+"\n");
  
   }

  // Clear guessed letters for the next word i.e.Make stack empty
 guessed.clear();
  //Incrementing for traversing to next word
randomIndex++;
wordIndex++;
System.out.println("Points earned:"+" "+score+"  "+"\n");
 
 System.out.println("Do you want to quit? Enter 1 for yes and 0 for No.");
 e=scanner.nextInt();
 
 }while(e!=0);
if(e==0) {
	return;
}
}

 }
 
 
 //Displaying rules of games

 void rules1() {

System.out.println("-------------------------Let's Guess the Word!!-----------------\n");



System.out.println("-------------------------ABOUT THE GAME--------------------------\n");



System.out.println("As name suggests it is a word guessing game.the player's objective is to guess a hidden word from a predefined list of words.\n The game uses a console-based interface and provides the player with a limited number of chances to guess the correct word \n\n");



System.out.println("RULES AND INSTRUCTIONS:");

System.out.println("--------------------------------------------------------------------------------------------------------");

System.out.println("1.Player's task is to guess correct letters from word and then it will be automatically displayed if the guess is right or wrong.");

System.out.println("2.Entered character should be strictly an alphabet");

System.out.println("3.For guessing each word only 6 chances will be given");

System.out.println("4.If user miss to guess word within 6 chances  then you will be directed to next word and correct answer will be displayed");

System.out.println("--------------------------------------------------------------------------------------------------------");

	 
 }



}




class Node {
    String word;
    String keyword;
    String key;
    String encryptword;
    Node left;
    Node right;

    public Node(String word, String keyword, String key, String encryptword) {
        this.word = word;
        this.keyword = keyword;
        this.key = key;
        this.encryptword = encryptword;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    private Node root;
    int count;
    Scanner sc=new Scanner (System.in);
   
    
    public BinarySearchTree() {
        root = null;
        count=0;
    }

    public void insert(String word, String keyword, String key, String encryptword) {
        root = insertRec(root, word, keyword, key, encryptword);
    }

    private Node insertRec(Node root, String word, String keyword, String key, String encryptword) {
        if (root == null) {
            return new Node(word, keyword, key, encryptword);
        }

        if (word.compareTo(root.word) < 0) {
            root.left = insertRec(root.left, word, keyword, key, encryptword);
        } else if (word.compareTo(root.word) > 0) {
            root.right = insertRec(root.right, word, keyword, key, encryptword);
        }

        return root;
    }
    public static void printVigenereSquare() {
        System.out.println("Vigenère Square:");

        // Determine the width of each cell to center-align
        int cellWidth = 3;

        for (char c = 'A'; c <= 'Z'; c++) {
            for (char d = 'A'; d <= 'Z'; d++) {
                String cell = String.format("%" + cellWidth + "s", (char)('A' + (c - 'A' + d - 'A') % 26));
                System.out.print(cell);
            }
            System.out.println();
        }
    }

     
   
 void cryption(Node ptr) {
	int[] opt= {1,2};
     Random random = new Random();
     int randomIndex = random.nextInt(2);       
     int choice = opt[randomIndex];
     switch (choice) {
     case 1:
	 System.out.println("word:"+ptr.word);
	 System.out.println(" HINT:lOOK FOR WORD LETTERS IN ROW AND KEY LETTERS IN COLUMN");
 	System.out.println("Encrypt the message:");
 	printVigenereSquare();
	 String en=sc.nextLine();
	 if(ptr.encryptword.compareTo(en)==0) {
		 System.out.println("Congrats!! you got it correct");
		count=count+10;
		System.out.println("YOUR SCORE : "+count);
	 }
	 else {System.out.println("Gotcha!!Its wrong");
	 System.out.println("The Encrypted word is:"+ptr.encryptword);
	 }
	
	 break;
	 
     case 2:
    	 System.out.println("word:"+ptr.encryptword);
    	 System.out.println(" HINT:lOOK FOR WORD LETTERS IN COLUMN AND KEY LETTERS IN ROW");
     	
     	System.out.println("Decrypt the message:");
     	printVigenereSquare();
    	 String dn=sc.nextLine();
    	 if(ptr.word.compareTo(dn)==0) {
    		 System.out.println("Congrats!!!");
    	 }
    	 else {System.out.println("Gotcha!!Its wrong");
    	 System.out.println("The word is:"+ptr.word);
    	 }
     }
   
	 
 }
 
    void search1(String key) {
		
		int flag=0;
		Node ptr=root;
		while(ptr!=null) {
			if(ptr.word.compareTo(key)==0) {
				
				System.out.println("keyword="+ptr.keyword);//hint
				System.out.println("key="+ptr.key);
				cryption(ptr);
				flag=1;
				break;
			}
			if(ptr.word.compareTo(key)>0)
			    ptr=ptr.left;
			    else   
			    	ptr=ptr.right;
		}
		if(flag==0) {
			System.out.println("word not found");
		}
	}

    
}



class cipher
{   String dword,eword,keyword;
   
    cipher(String d,String k){
    	dword=d;
     
    	keyword=k;
    }
    
    cipher(){
    	System.out.println("*************************************WELCOME**************************************");
    	System.out.println("--------------------------------------------------------------------------------------------------------");

    	System.out.println("                                 Cipher Quest: The Vigenère Challenge                                      ");
    	System.out.println("--------------------------------------------------------------------------------------------------------");

        System.out.println("                    Prepare to embark on a thrilling journey into the world of secret codes");
        System.out.println("Rules");
        System.out.println("--------------------------------------------------------------------------------------------------------");

        System.out.println("1.The game wants you to encrypt or decrypt the word.WRITE IN CAPITAL LETTERS!!!"); 
        System.out.println("2.BE Aware!!Question will randomly generate an encrypted or decrypted word  ");
        System.out.println("3.A key will be provided and Vigenere table will be displayed for reference");
        System.out.println();
        System.out.println("4.To DECRYPT Follow this:\r\n"
        		+ "The first letter is selected using the priming key.\r\n"
        		+ "The first letter of the ciphertext is located in this row.\r\n"
        		+ "The first letter of the plaintext will be the letter where the first row and column intersect.\r\n"
        		+ "This process is followed until the entire ciphertext is deciphered.\r\n"
        		+ "");
        System.out.println();
        System.out.println("5.To ENCRYPT FOLLOW this:\r\n "
        		+ "The first letter of the ciphertext will be the letter where the first row and column intersect. \r\n"
        		+ "Now, this process is continued Write the plaintext.\r\n"
        		+ "Use the plaintext and the key letter to select a row and a column in the Vigenere table.\r\n"
        		+ "The first letter of the plaintext is the first row and the key is the first column. ");
    }
    
 
    public  void encryptDecrypt(String plaintext, String keyword)
    {
 //Converting plaintext to char array
 char msg[] = plaintext.toCharArray();
 int msgLen = msg.length;
 int i,j;
  
 // Creating new char arrays
 char key[] = new char[msgLen];
 char encryptedMsg[] = new char[msgLen];
 char decryptedMsg[] = new char[msgLen];
  
 /* generate key, using keyword in cyclic 
 manner equal to the length of 
 original message i.e plaintext */
 for(i = 0, j = 0; i < msgLen; ++i, ++j)
 {
  if(j == keyword.length())
  {
   j = 0;
  }
  key[i] = keyword.charAt(j);
 }
  
 //encryption code 
 for(i = 0; i < msgLen; ++i)
  encryptedMsg[i] = (char) (((msg[i] + key[i]) % 26) + 'A');
 
 //decryption code
 for(i = 0; i < msgLen; ++i)
  decryptedMsg[i] = (char)((((encryptedMsg[i] - key[i]) + 26) % 26) + 'A');
  
 System.out.println("Original Message: " + plaintext);  
 System.out.println("Keyword: " + keyword);
 /* String.valueOf() method converts
    char[] to String */
 System.out.println("Key: " + String.valueOf(key));
 System.out.println();
 System.out.println("Encrypted Message: " + String.valueOf(encryptedMsg));
 System.out.println();        
 System.out.println("Decrypted Message: " + String.valueOf(decryptedMsg));
   }
    
public   void crypto() {
	Scanner sc=new Scanner (System.in);
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert("ORIGINAL", "FAKE", "FAKEFAKE", "TRSKNNKP");
    bst.insert("HAPPINESS", "REQUIRED", "REQUIREDR", "YEFJQEIVJ");
    bst.insert("GESTURE", "WARM", "WARMWAR", "CEJFQRV");
    bst.insert("GUINNESS", "RECORD", "RECORDRE", "XYKBEHJW");
    bst.insert("APPLE", "OPEN", "OPENO", "OETYS");
    bst.insert("MAGIC", "JAADU", "JAADU", "VAGLW");
    bst.insert("MESMERIZING", "DARK", "DARKDARKDAR", "PEJWHRZJLNX");
    
    
    bst.insert("ILOVEJAVA", "LEMON", "LEMONLEMO", "TPAJRUEHO");
    
    bst.insert("TRANQUIL", "CALM", "CALMCALM", "VRLZSUTX");
    bst.insert("QUEEN", "KING", "KINGK", "ACRKX");
    bst.insert("POPULAR", "FAME", "FAMEFAM", "UOBYQAD");
    bst.insert("THANKSFORPLAYING", "ROSE", "ROSEROSEROSEROSE", "KVSRBGXSIDDEPWFK");
    
    bst.insert("YOUAREBEAUTIFUL", "LOOK", "LOOKLOOKLOOKLOO", "JCIKCSPOLIHSQIZ");
    
    bst.insert("WONDERFUL", "COLORFUL", "COLORFULC", "YCYRVWZFN");
   
     bst.insert("YOUNGER", "ELDER", "ELDEREL", "CZXRXIC");
   
    
// Generate random words to search
    String[] wordsToSearch = {"APPLE", "ILOVEJAVA", "YOUAREBEAUTIFUL", "HAPPINESS", "MESMERIZING", "WONDERFUL","QUEEN","TRANQUIL","POPULAR","YOUNGER","GESTURE","ORIGINAL","GUINNESS","MAGIC","THANKSFORPLAYING"};
    
            Random random = new Random();
            
            int ch=1;
            while (ch!=0) {
         int randomIndex = random.nextInt(wordsToSearch.length);       
                String searchWord = wordsToSearch[randomIndex];
                bst.search1(searchWord);
                System.out.println("wanna continue playing?If yes press 1 else press 0 :");
                ch=sc.nextInt();
            }
}      
        
}


class ROranges{

int arr[][]= new int[6][6];

ROranges(){

rules();


}

void g() {

Random r= new Random();

for(int i=0;i<6;i++) {

for(int j=0;j<6;j++) {

int h=r.nextInt();

int d=h % 3;

if(d<0) {

d=-d;

}

arr[i][j]= d;

}

}

oran(6,6);

}


Scanner sc = new Scanner(System.in);


void oran(int x,int y) {



Orange n= new Orange(x,y);

for(int i=0;i<x;i++) {

for(int j=0;j<y;j++) {

System.out.print(" "+arr[i][j]);

}

System.out.println();

}

System.out.println();

int ans = n.rotOranges(arr);

while(true) {

System.out.println(" TO          | TO PRESS :                           |");
System.out.println(" ------------|--------------------------------------|");
System.out.println(" SEE ANSWER  | 'Y' (THERE BY YOU WILL END THE GAME) |");
System.out.println(" CONTINUE    | 'N' OR ANY CHARACTER KEY             |");
System.out.println(" QUIT        | 'Q'                                  |");
System.out.println(" ------------|--------------------------------------|");
System.out.println("");

System.out.println(" ENTER YOUR CHOICE :");


char d=sc.next().charAt(0);

if(d=='q' || d=='Q') {

return;

}

else if(d!='y' && d!='Y') {


System.out.println("\nEnter your answer : ");

int g=sc.nextInt();

int f=1;

if(g!=ans) {

System.out.println("Your answer is wrong !! \n\n ");


f++;

} else if(ans==g) {

System.out.println(" CONGRATULATIONS !!!! \n\n YOU WON !! ");

}

else {


}}

else {



System.out.println(" Correct anwer is :\n");

if (ans == -1)

System.out.println( "All oranges cannot rot");

else

System.out.println(

" Time required for all oranges to rot :  "

+ ans);;


return ;

}}

}

class Orange{

int R =0,C=0;


List<O> b= new ArrayList<>();



public Orange(int n,int m) {

R=n;

C=m;


}

class Ele {

int x = 0;

int y = 0;

Ele(int x, int y)

{

this.x = x;

this.y = y;

}

}

void ans() {

for(int i=0;i<b.size();i++) {

System.out.println("LOCATION : "+b.get(i).i+" , "+b.get(i).j+" | TIME : "+b.get(i).t+"min");

}

}

boolean isValid(int i, int j)

{

return (i >= 0 && j >= 0 && i < R && j < C);

}


boolean isDelim(Ele temp)

{

return (temp.x == -1 && temp.y == -1);

}


// Function to check whether there is still a fresh

// orange remaining

boolean checkAll(int arr[][])

{

for (int i = 0; i < R; i++)

for (int j = 0; j < C; j++)

if (arr[i][j] == 1)

return true;

return false;

}


// This function finds if it is possible to rot all

// oranges or not. If possible, then it returns minimum

// time required to rot all, otherwise returns -1

class O{

int i, t,j;

O(int i,int j,int t){

this.i=i;

this.j=j;

this.t=t;

}

}

int rotOranges(int arr[][])

{

// Create a queue of cells

Queue<Ele> Q = new LinkedList<>();

Ele temp;

int ans = 0;

// Store all the cells having rotten orange in first

// time frame

for (int i = 0; i < R; i++)

for (int j = 0; j < C; j++)

if (arr[i][j] == 2)

Q.add(new Ele(i, j));



Q.add(new Ele(-1, -1));


while (!Q.isEmpty()) {

// This flag is used to determine whether even a

// single fresh orange gets rotten due to rotten

// oranges in the current time frame so we can

// increase the count of the required time.

boolean flag = false;


// Process all the rotten oranges in current

// time frame.


while (!isDelim(Q.peek())) {

temp = Q.peek();


// Check right adjacent cell that if it can

// be rotten

if (isValid(temp.x + 1, temp.y)

&& arr[temp.x + 1][temp.y] == 1) {

if (!flag) {

// if this is the first orange to

// get rotten, increase count and

// set the flag.

b.add(new O(temp.x + 1,temp.y,ans));

ans++;

flag = true;

}

// Make the orange rotten

arr[temp.x + 1][temp.y] = 2;


// push the adjacent orange to Queue

temp.x++;

Q.add(new Ele(temp.x, temp.y));


// Move back to current cell

temp.x--;

}


// Check left adjacent cell that if it can

// be rotten

if (isValid(temp.x - 1, temp.y)

&& arr[temp.x - 1][temp.y] == 1) {

if (!flag) {

ans++;

flag = true;

}

arr[temp.x - 1][temp.y] = 2;

temp.x--;

Q.add(new Ele(

temp.x,

temp.y)); //

temp.x++;

}


// Check top adjacent cell that if it can be

// rotten

if (isValid(temp.x, temp.y + 1)

&& arr[temp.x][temp.y + 1] == 1) {

if (!flag) {

ans++;

flag = true;

}

arr[temp.x][temp.y + 1] = 2;

temp.y++;

Q.add(new Ele(

temp.x,

temp.y)); // Push this cell to Queue

temp.y--;

}


if (isValid(temp.x, temp.y - 1)

&& arr[temp.x][temp.y - 1] == 1) {

if (!flag) {

ans++;

flag = true;

}

arr[temp.x][temp.y - 1] = 2;

temp.y--;

Q.add(new Ele(

temp.x,

temp.y)); // push this to Queue

}

Q.remove();

}


Q.remove();



if (!Q.isEmpty()) {

Q.add(new Ele(-1, -1));

}


// If Queue was empty than no rotten oranges

// left to process so exit

}


// Return -1 if all arranges could not rot,

// otherwise ans

return (checkAll(arr)) ? -1 : ans;//ternary operator

}



}

void rules() {

System.out.println("\nLET'S PLAY ROTTEN ORANGES GAME ! ! ! \n");

System.out.println("ABOUT THE GAME --\n");

System.out.println(" Given a matrix of dimension M * N, where each cell in the matrix can have values 0, 1 or 2 which has the following meaning: \r\n"

+ "\n"

+ "0: Empty cell\r\n"

+ "1: Cells have fresh oranges\r\n"

+ "2: Cells have rotten oranges.\n");

System.out.println("  RULES AND INSTRUCTIONS :");

System.out.println(" -------------------------------------------------------------------------------------------------------------------------------");

System.out.println(" 1. The task is to find the minimum time required so that all the oranges become rotten (time in minute).");

System.out.println(" 2. A rotten orange at index (i,j ) can rot other fresh oranges which are its neighbors (up, down, left, and right)[in one minute].");

System.out.println(" 3. If it is impossible to rot every orange then simply write -1 ");

System.out.println(" -------------------------------------------------------------------------------------------------------------------------------\n");

}


}

class Nqueens{

int n;

Scanner sc=new Scanner(System.in);

char[][] q;

Nqueens(){

rules();

}

Nqueens(int n){

this.n=n;

q=new char[n][n];


}

void g() {

for(int i=0;i<n;i++ ) {

for(int j=0;j<n;j++){

q[i][j]='X';


}

}

}

void h(int row,char a[][]) {

if(row==n) {


for(int i=0;i<n;i++) {

for(int j=0;j<n;j++) {

System.out.print(" "+a[i][j]);;

}

System.out.println();

}


System.out.println();

System.out.println(" OR");

System.out.println();

return ;


}

for(int i=0;i<n;i++) {

if(Safe(row,i)) {

a[row][i]='Q';

h(row+1,a);

a[row][i]='X';//backtracking

}


}

}


void f() {


display();


int f=n*n;

int h=1;

int g=0;

while(h!=f) {

System.out.println(" TO -        | PRESS :                              |");
System.out.println(" ------------|--------------------------------------|");
System.out.println(" SEE ANSWER  | 'Y' (THERE BY YOU WILL END THE GAME) |");
System.out.println(" CONTINUE    | 'N' OR ANY CHARACTER KEY             |");
System.out.println(" QUIT        | 'Q'                                  |");
System.out.println(" ------------|--------------------------------------|");
System.out.println("");
System.out.println(" ENTER YOUR CHOICE :");


char d=sc.next().charAt(0);

if(d=='q' || d=='Q') {

return;

}

else if(d!='y' && d!='Y') {

if(g<n+1) {

System.out.println("TO PLACE THE QUEEN -: ");

System.out.println("Enter the row: ");

int j= sc.nextInt();
while(j<=0 || j>=n) {
	System.out.println("Enter the correct row please !! : ");
	j= sc.nextInt();
}

System.out.println("Enter the column: ");

int k= sc.nextInt();
while(k<=0 || k>=n) {
	System.out.println("Enter the correct column please !! : ");
	k= sc.nextInt();
}

int r=j-1;
int c=k-1;

if(Safe(r,c)) {

g++;

q[r][c]='Q';

if(g==n) {

display();

System.out.println(" CONGRATULATIONS !!!! \n\n YOU WON !! ");

return ;

}



display();


h++;


}

else {

System.out.println("This 'Queen' would KILL another 'Queen'..... \n\nSo you cannot place the Queen at given location !!! ");

display();

System.out.println("WANT TO REMOVE QUEEN ? : IF YES THEN PRESS 1..ELSE 0..");

int y=sc.nextInt();

while(y==1 && g!=0) {

System.out.println("Enter the row : ");

int row= sc.nextInt();

System.out.println("Enter the column : ");

int col= sc.nextInt();

if(q[row][col]=='Q') {

g--;

}

q[row][col]='X';

display();

System.out.println("WANT TO EMOVE QUEEN ? : IF YES THEN PRESS 1..ELSE 0..");

y=sc.nextInt();

}

}}

else {int p=0;

display();

System.out.println("Queens are greater than N ...");

System.out.println("want to remove Queen ? : IF YES THEN PRESS 1..ELSE 0..");

int y=sc.nextInt();

while(y==1) {


System.out.println("enter the row: ");

int row= sc.nextInt();

System.out.println("enter the col: ");

int col= sc.nextInt();

if(q[row][col]=='Q') {

g--;

}

q[row][col]='X';

display();

System.out.println("want to remove Queen ? : IF YES THEN PRESS 1..ELSE 0..");

y=sc.nextInt();

}


}

}else {

System.out.println();

System.out.println("ANSWER : \nPOSSIBLE CONFIGURATIONS - \n");

g();

h(0,q);

return;

}

}


}

void display() {

System.out.println();

for(int i=0;i<n;i++) {

for(int j=0;j<n;j++) {


System.out.print(" "+q[i][j]);

}

System.out.println();

}

System.out.println();

}



boolean Safe(int row ,int col) {

for(int i=0;i<n;i++) {

if(q[row][i]=='Q') {

return false;

}

}

for(int i=0;i<n;i++) {

if(q[i][col]=='Q') {

return false;

}

}

for(int i=row,j=col;(i<n && j<n);i++,j++) {

if(q[i][j]=='Q') {

return false;

}

}


for(int i=row,j=col;(i>=0 && j>=0);i--,j--) {

if(q[i][j]=='Q') {

return false;

}

}


for( int i=row,j=col;(i<n && j>=0);i++,j--) {

if(q[i][j]=='Q') {

return false;

}

}

for( int i=row,j=col;(i>=0 && j<n);i--,j++) {

if(q[i][j]=='Q') {

return false;

}

}



return true;



}


void play() {

g();

f();

}

void rules() {

System.out.println("\nLET'S PLAY N-QUEENS ! ! ! \n");

System.out.println("ABOUT THE GAME --\n");

System.out.println(" N - 'Queens' problem is to place n - queens in such a manner on an n x n chessboard that no queens attack each other by being in the same row, column or diagonal.\n");

System.out.println(" RULES AND INSTRUCTIONS :");

System.out.println(" ----------------------------------------------------------------------------------------------------------");

System.out.println(" 1. A Queen CAN KILL ANY OTHER 'Queen' FROM AND ALONG THE ALL  8 POSSIBLE DIRECTIONS.");

System.out.println(" 2. YOU HAVE TO ENTER ROW AND COLUMN STARTING FROM 1..N..");

System.out.println(" 3. ANSWERS ARE ONLY POSSIBLE FOR N>3...FOR N<3 WE CANNOT PLACE ANY QUEEN ....... ");

System.out.println(" 4. HERE'S THE CATCH - YOU CAN REMOVE THE 'Queen' ONLY IF YOU PLACE THE NEXT 'Queen' INCORRECTLY AND YOU WILL BE WARNED..");

System.out.println(" -----------------------------------------------------------------------------------------------------------");

}

}


public class Y {

static Scanner sc=new Scanner(System.in);

static void Nqueen() {

Nqueens p= new Nqueens();

System.out.println("\nDO YOU WANT TO PLAY THE GAME : IF NO THEN PRESS '0' OR ELSE ANY NUMBER :");

int y=sc.nextInt();

if(y==0) {
return ;
}
System.out.println("Enter the VALUE of 'N' for N queens(integer) :");
int g=sc.nextInt();
while(g<=3 && g>10) {
	System.out.println(" PLEASE Enter the correct value of 'N'");
	g=sc.nextInt();
}
Nqueens n= new Nqueens(g);
n.play();
System.out.println("\n    WOULD LIKE TO KNOW THE HISTORY OF  'NQueens' ?\n    AND SOME MORE INFPRMATION IF YES THEN PRESS '4': \n");
int o=sc.nextInt();
if(o==4) {
	System.out.println("  HISTORY  : \n");
	System.out.println("  ALGORITHM WHICH WE USED TO SOLVE THE PROBLEM IS - BACKTRACKING ");
	System.out.println("  First posed by Max Bezzel in 1848, the problem of placing eight queens on a\r\n"
			+ " chessboard in mutually non attacking positions was solved in 1850 by Franz Nauck. \n");
	System.out.println("  WHAT YOU GAINED FROM 'N Queens' GAME ?\n ");
	System.out.println(" 1) Problem-Solving Skills\n 2) Spatial Reasoning\n 3) Understanding  'Backtracking'  \n ");
	return;
	
}else {
	return ;
}


}


static void Oranges() {

ROranges p= new ROranges();

System.out.println("\nDO YOU WANT TO PLAY THE GAME : IF NO THEN PRESS '0' OR ELSE ANY NUMBER :");

int y=sc.nextInt();

if(y==0) {

return ;

}

p.g();
System.out.println("\n    WOULD LIKE TO KNOW THE HISTORY OF 'ROTTEN ORANGES' ?\n    AND SOME MORE INFPRMATION IF YES THEN PRESS '4': \n");
int o=sc.nextInt();
if(o==4) {
	System.out.println("       HISTORY :\n");
	System.out.println("  ALGORITHM WHICH WE USED TO SOLVE THE QUESTION IS 'BFS' - BREADTH FIRST SEARCH \n");
	System.out.println("  BFS was invented in 1945 by Konrad Zuse,\n "
			+ "  1in his (rejected) Ph. D. thesis on the Plankalkül programming language, but this was not published until 1972.\n");
	System.out.println("  WHAT YOU GAINED FROM 'ROTTEN ORANGES' ? : \n");
	System.out.println(" 1) Approach related to tiing problems.\n 2) Understanding importance of BFS.\n 3) Problem solving skills. \n ");
}else {
	return;
}

}
static void Word() {

	Word_Guess w=new Word_Guess();
	System.out.println("\nDO YOU WANT TO PLAY THE GAME : IF NO THEN PRESS '0' OR ELSE ANY NUMBER :");

	int y=sc.nextInt();

	if(y==0) {

	return ;

	}
	w.word_guess();	
	System.out.println("\n    WOULD LIKE TO KNOW THE HISTORY OF GAME ?\n    AND SOME MORE INFPRMATION IF YES THEN PRESS '4': \n");
	int o=sc.nextInt();
	if(o==4) {
		System.out.println("       HISTORY :\n");
		System.out.println("  Le Pendu,\" a game played in France during the 18th century.\n  In this game, players guessed words or phrases, and for each incorrect guess, a part of a hanged man was drawn, eventually leading to the completion of the \"hangman.\"");
		System.out.println("  WHAT YOU GAINED FROM 'WORD GUESS GAME' ? : \n");
		System.out.println("  1) Increases focus.\n 2) Enhances vocabulary.\n 3) Cognitive Skills.");
	}else {
		return;
	}
	
}
 static void cryptography() {
	cipher c=new cipher();
	System.out.println("\nDO YOU WANT TO PLAY THE GAME : IF NO THEN PRESS '0' OR ELSE ANY NUMBER :");

	int y=sc.nextInt();

	if(y==0) {

	return ;

	}
	c.crypto();
	System.out.println("\n    WOULD LIKE TO KNOW THE HISTORY OF GAME ?\n    AND SOME MORE INFPRMATION IF YES THEN PRESS '4': \n");
	int o=sc.nextInt();
	if(o==4) {
		System.out.println("       HISTORY :\n");
		System.out.println("  “Before the 1960-70s, cryptography was more an art than science.”\r\n"
				+ "  It is believed that Julius Caesar used  cryptography, now called Caesar’s cipher, to communicate with his aides.");
		System.out.println("  The Vigenère cipher gained a reputation for being exceptionally strong.\n");
		System.out.println("  WHAT YOU GAINED FROM 'CIPHER GAME' ? : \n");
		System.out.println(" 1)Increases knowledge\r\n"
				+ "  2)Improves creativity\n  3)Develops patience and persistence");
		
		
	}else {
		return;
	}
	
	
	
}

public static void main(String[] args) {

Scanner sc=new Scanner(System.in);

System.out.println();

System.out.println("                                                                            *-*-* WELCOME TO QUIZONE *-*-*\n");

System.out.println("   WHAT IS QUIZONE ABOUT ? -- \n\n IT'S A COLLECTION OF 'EDUACTIVE' *SINGLE PLAYER GAMES\n WHICH REQUIRE BASIC MATHS AND LOGIC FOR SOLVING QUESTIONS..\n"
		+ "\n HERE IS THE COLLECTION OF '4' GAMEZ WHICH HAVE THEIR OWN HISTORY AND DEVELOP COGNITIVE SKILLS...");

System.out.println("\n SO LET'S START 'EDUGAMING' : \n");

int choice;

do

{

System.out.println(" PICK ONE GAME :\n\n 1.N QUEENS\n\n 2.ROTTEN ORANGES\n\n 3.WORD GUESS GAME \n\n 4.CIPHER QUEST\n");

System.out.println(" ENTER THE CHOICE TO PLAY THE GAME : (1,2,3..)\n");


choice=sc.nextInt();

switch(choice)

{

case 1: Nqueen();

break;

case 2: Oranges();

break;

case 3:Word();

break;

case 4:cryptography();

break;

default : System.out.println(" You entered the wrong option ! ! !");

}

System.out.println("\n Do you want to continue gaming in 'QUIZONE' ?\n IF yes then enter any number , IF NO then '0' :");

System.out.println();

choice = sc.nextInt();


}while(choice!=0);

System.out.println(" IN THIS 'ERA OF PUBG' THANKS FOR TRYING 'EDUGAMEZ - QUIZONE' \n         PLEASE CONTINUE EDUGAMING...\n         THANKYOU !!! ");

}

}