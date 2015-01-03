http://abhi121a.test/jenkins/

Setup a project using eclipse, maven and jenkins with github repositories

1. Install eclipse
2. Install JDK JRE and set up all environmnet variables.
3. Install maven and set all the environment variables as needed.
4. Intall Testng in eclipse by clicking HELP>INSTALL NEW SOFTWARE  and in new popup window - Install enter WOrk with: as TestNG - http://beust.com/eclipse Install it.

5. In eclipse goto HELP>Eclipse Marketplace Install Maven integration for Eclipse.
6. Create a new maven project from file>new>project from the popup window select Maven project.
7. Goto Build path and delete the old jre i.e jre5 and update with new as jre7.
8. download jar files and include in build path or Add new dependencies for testng, jxl, selenium.
   to add dependencies below data will be useful.
   dependencies in maven for testing- This will update the pom XML which is created with project.

first: testng


<dependency>
  <groupId>org.testng</groupId>
  <artifactId>testng</artifactId>
  <version>6.1.1</version>
  <scope>test</scope>
</dependency>


Second: Selenium

 <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>2.44.0</version>
    </dependency> 


third: JXL

<dependency>
	<groupId>net.sourceforge.jexcelapi</groupId>
	<artifactId>jxl</artifactId>
	<version>2.6</version>
</dependency>

check for errors if any and google it.  :)

9. In src/test/java create your test scipts in pakages as page and testngscripts.
10.After scripting and successfully running the testng scripts We will start with creating a repository in Github and then configuring with Jenkins 
Git Software-Git is a distributed version control system, it can be used as a server out of the box.Dedicated git server software helps, amongst other features, to add access control, display the contents of git repository via web, and help managing multiple repositories.

In laymen word: Git allows team of people to work together, all using the same files.And it helps the team to cope with the confusion the tends to happen when multiple people are editing the same files.

There are many ways it can be set up and configured, but at my job, here's how we use it: when a new employee starts, he downloads all the files from Github, which is an online server we're all connected to. 

So he has his local version of the files, I have my local version, our boss has HIS local version, etc.

When I make a change to some files, I go through the following process in the Terminal. (There are GUI clients for Git, but I prefer working on the command line.)

> git pull

That pulls the latest changes down from github. If there are contradictions between those and my local ones, it tells me what they are, file-by-file, line-by-line, and I now have a chance to reconcile those differences.

> git add .

That adds all of my local changes to Git, so that Git knows about them. The dot after add specifically means to add ALL the changes I've made, e.g. new files I've added to my local folder or changes I've made to existing files. If I want, I can add only specific files, e.g. 

> git add myNewFile.txt

I now write a comment about the adds I just made.

> git commit -m "Fixed a major bug which stopped reports from printing."

Finally, I upload my changes to the server.

> git push

Now, when my colleagues do a ...

> git pull

... they will get my changes, and they will be notified if any of them conflict with their local versions.

There are all kinds of cool, useful commands for rolling back changes to a particular time or state. But probably the most useful thing about Git is branching. Let's say my team is working on code for an Asteroids game, and I get the idea for making spinning asteroids. This will involve making some major changes to the existing asteroids code, and I'm a little scared to do that. No worries, I can just make a branch.

First of all, I'll check which branches exist:

[code]> git branch
master*[/code]

So there's currently only one branch on my local machine, called master. The star by it means that's the branch I'm currently working in. I'll go ahead and create a new one:

> git branch spinningAsteroids

That creates a copy of all the files in master. I'll now move into that branch.

[code]> git checkout spinningAsteroids
> git branch
master
spinningAsteroids*[/code]

I now spend a couple of hours in spinningAsteroids, doing whatever coding I need to do, not worrying about messing things up, because I'm in a branch. Meanwhile, I get a tech support call. They've found a critical bug and I need to fix it asap. No worries...

> git checkout master

... fix bug ...

1
2
3
4
> git pull
> git add .
> git commit -m "Fixed critical bug with high scores."
> git push


Now I can resume my work with spinningAsteroids.

[code]> git checkout spinningAsteroids
> git branch
master
spinningAsteroids*[/code]


... work, work, work ...

Okay, I'm now happy with my spinning asteroids, and I want to merge that new code into the main code base, so...

[code]> git checkout master
> git branch
master*
spinningAsteroids[/code]

> git merge spinningAsteroids

Now the code from my branch is merged into the main code-base. I can now upload it.

1
2
3
4
> git pull
> git add .
> git commit -m "added new cool feature! Spinning asteroids!!!"
> git push


There are many ways to use Git. This is just one of them.


11.Before Using git intall gitshell in your system.Or github gui application now and create a new account in github.com with creating of a new repository in it.
12. Now open gitshell and using ls and cd .. navigate to the location you have pom.xml created with your maven project in above steps.
13. Use below command for pusing all the files into it.

touch README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/abhi121a/test_test.git
git push -u origin master

14. now if you refresh your git you will se all the files and folder in Github web page.

15. Now you are done with Github now we Install Jenkins.

jenkins is a CI tool (Open source) i.e. Continious integration tool for automatic builds. It can build after every commit.
mostly used for prod environment.      :!

16. Setup for jenkins download jenkins from http://jenkins-ci.org/ it will install as server which can be accessed by below link:

http://localhost:8080/

17. Once it is downloaded and installed lets setup it.
ok it will be allready logged in as anonymous user.
	1. click on manage jenkins from left menue.
	2. in Manage jenkins click on Manage plugins.
	3. in new page click on available tab.
	4. Search for git plugin and github plugin and install them.
	5. Restart jenkins.
18. In Manage jenkins page you will get an alert message related to disabled security.
	to fix this issue or enable security, click on Configure Global Security in Manage Jenkins page.
	and click on enable sercurity.
	click on Jenkins own user database, allow user to sign in.
	click on Project-based Matrix Authorization Strategy under authorization.

19. click on configure system in Manage jenkins page.
	Click on JDK installation and give path for Java_home.
	Click on Git give the path of git executable where the git.exe file is placed in system mostly as C:\Program Files 	(x86)\Git\bin\git.exe.
	navigate down to Email notifications
	give smtp server: smtp.gmail.com
	default email suffix : @gmail.com
	in Advanced of above fill as below 
	tick Use SMTP Authentication
	give gmail username and password.
	tick SSL
	SMTP port : 465
	reply to address: as your gmail account abhi121a@gmail.com
	then save the page.

20. Now we can create an new Item by clicking New Item from the left hand menu
21. Give Item name: asda test and select Maven project.
22. fill the configure page as below:
23. give github project name: https://github.com/abhi121a/Asda_repo/  
	// as it was in github web page.
24. In Source code management select git and provide Repository url as http://github.com/abhi121a/Asda_repo.git 
// this you can copy paste  from github web page as http clone url

25. give email in email notifications and Save it.

NOw you are ready to built it using eclipse, testng selenium , git, maven and jenkins.




