package leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import  java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * DFS深度优先遍历进行查询，此方法有一个弊端，就是时间太久，很容易超时
 */
public class FindLadders {
  private ArrayList<String> temp;
  private List<List<String>> result;
  private List<String> wordList;
  private int minSize = Integer.MAX_VALUE;
  boolean isFound = false;

  public List<List<String>> DFSFindLadders(String beginWord, String endWord, List<String> wordList) {
    if (wordList.indexOf(endWord) < 0) {
      return new LinkedList<>();
    }

    this.wordList = wordList;
    this.result = new ArrayList<>();
    this.temp = new ArrayList<>();
    temp.add(beginWord);
    this.DFSFindLadderHelp(beginWord, endWord);
    return this.result;
  }

  private void DFSFindLadderHelp(String beginWord, String endWord) {
    int tempSize = temp.size();

    if (tempSize > 0 && temp.get(tempSize - 1).equals(endWord)) {
      if (tempSize < minSize) {
        result.clear();
        result.add(new ArrayList<>(temp));  // 当前是最短路径，所以需要将当前的数组进行压栈
        minSize = temp.size();
      } else if (tempSize == minSize) {
        result.add(new ArrayList<>(temp));  // 相同长度的List要一起入栈
      }
      return ;
    }

    if (tempSize >= minSize) {
      // 当temp数组的长度大于最小值的时候，是没有必要进行下去的
      return ;
    }

    for (String next : wordList) {
      if (temp.contains(next)) {
        // 已经遍历过的没必要再进行遍历
        continue;
      }

      if (isOneChanged(beginWord, next)) {
        temp.add(next);
        DFSFindLadderHelp(next, endWord);
        // 这里是关键代码，每一步进行递归调用的时候，temp会增加一个内容，当调用结束的时候，减少增加的内容是一个关键
        temp.remove(temp.size() - 1);
      }
    }
  }

  private boolean isOneChanged(String target, String pattern) {
    int changeCount = 0;
    for (int i = 0; i < target.length(); i++) {
      if (target.charAt(i) != pattern.charAt(i)) {
        changeCount++;
      }
    }

    return changeCount == 1;
  }

  public List<List<String>> BFSFindLadders(String beginWord, String endWord, List<String> wordList) {
    if (wordList.indexOf(endWord) < 0) {
      return new LinkedList<>();
    }

    this.wordList = wordList;
    this.result = new ArrayList<>();
    this.temp = new ArrayList<>();
    temp.add(beginWord);
    this.BFSFindLadders(beginWord, endWord);
    return result;
  }

  private void BFSFindLadders(String beginWord, String endWord) {
    ArrayList<ArrayList<String>> nextList = new ArrayList<>();

    for (String next : wordList) {
      if (temp.contains(next)) {
        continue;
      }

      if (isOneChanged(beginWord, next)) {
        temp.add(next);
        nextList.add(new ArrayList<>(temp));
        temp.remove(temp.size() - 1);
      }
    }

    for (ArrayList<String> temp : nextList) {
      if (temp.contains(endWord) && (temp.size() <= minSize)) {
        if (temp.size() < minSize) {
          this.minSize = temp.size();
          result.clear();
        }
        result.add(temp);
        isFound = true;
      }
    }

    if (!isFound || temp.size() < minSize) {
      for (ArrayList<String> temp : nextList) {
        this.temp = temp;
        BFSFindLadders(temp.get(temp.size() - 1), endWord);
      }
    }
  }

  @Test
  public void test01() {
    String beginWord = "cet";
    String endWord = "ism";
    List<String> arr = new ArrayList<>();
    String[] strArr = new String[]{"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
    for (int i = 0; i < strArr.length; i++) {
      arr.add(strArr[i]);
    }
    System.out.println(new FindLadders().BFSFindLadders(beginWord, endWord, arr));
  }
}
