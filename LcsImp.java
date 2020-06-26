import java.io.*;
import java.util.*;
class LcsImp
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
String s1 = sc.next();
String s2 = sc.next();
int len = findLen(s1,s2);
System.out.println("Length of the Longest Subsequence is :"+len);
}
static int findLen(String s1,String s2)
{
int len1 = s1.length();
int len2 = s2.length();
char x[] = s1.toCharArray();
char y[] = s2.toCharArray();
int subset[][] = new int[len1+1][len2+1];
int i,j;
for(i=0;i<=len1;i++)
{
for(j=0;j<=len2;j++)
{
if(i==0 || j==0)
subset[i][j] = 0;
}
}

for(i=1;i<=len1;i++)
{
for(j=1;j<=len2;j++)
{
if(s1.charAt(i-1) == s2.charAt(j-1))
{
subset[i][j] = 1+ subset[i-1][j-1];
}
else
{
subset[i][j] = max(subset[i-1][j],subset[i][j-1]);
}
}
}
return subset[len1][len2];
}

static int max(int a, int b)
{
return(a>b)?a : b;
}
}