# covid19tracker

Covid19Tracker is a Proof of Concept of Azure Cloud Services.

Installation Instructions 

Login to Ubuntu Server


#JDK Installation

# install JAVA on ubuntu 

sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys 0xB1998361219BD9C9

sudo apt-add-repository 'deb http://repos.azulsystems.com/ubuntu stable main'


sudo apt update

sudo apt install zulu-8

java -version

# Installation of Apache Tomcat Sever 9.0.39

sudo groupadd tomcat

sudo useradd -s /bin/false -g tomcat -d /opt/tomcat tomcat

cd /tmp

wget https://apache.claz.org/tomcat/tomcat-9/v9.0.39/bin/apache-tomcat-9.0.39.tar.gz

sudo mkdir /opt/tomcat

sudo tar xzvf apache-tomcat-*tar.gz -C /opt/tomcat --strip-components=1

cd /opt/tomcat

sudo chgrp -R tomcat /opt/tomcat

sudo chmod -R g+r conf

sudo chmod g+x conf

sudo chown -R tomcat webapps/ work/ temp/ logs/

sudo update-java-alternatives -l

sudo nano /etc/systemd/system/tomcat.service

copy below script in tomcat.service

# script for tomcat.service 
################################################

[Unit]

Description=Apache Tomcat Web Application Container

After=network.target


[Service]

Type=forking


Environment=JAVA_HOME=/usr/lib/jvm/zulu-8-amd64

Environment=CATALINA_PID=/opt/tomcat/temp/tomcat.pid

Environment=CATALINA_HOME=/opt/tomcat

Environment=CATALINA_BASE=/opt/tomcat

Environment='CATALINA_OPTS=-Xms512M -Xmx1024M -server -XX:+UseParallelGC'

Environment='JAVA_OPTS=-Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom'


ExecStart=/opt/tomcat/bin/startup.sh

ExecStop=/opt/tomcat/bin/shutdown.sh

User=tomcat

Group=tomcat

UMask=0007

RestartSec=10

Restart=always

[Install]

WantedBy=multi-user.target

##########################################3


sudo systemctl daemon-reload

chmod +777 -R /opt/tomcat/*

change port number "8080" to "80" in server.xml


# install authbind


 sudo apt-get install -y authbind 
 

# changes in startup.sh in tomcat/bin 

comment exiting line "$PRGDIR"/"$EXECUTABLE" start "$@"

add below line 

exec authbind --deep  "$PRGDIR"/"$EXECUTABLE" start "$@"


# allow port 80 access to authbind 


sudo touch /etc/authbind/byport/80; 

sudo chmod 500 /etc/authbind/byport/80; 

sudo chown tomcat /etc/authbind/byport/80

sudo cp covid19tracker.war /opt/tomcat/webapps/covid19tracker.war

sudo systemctl start tomcat

open the browser and paste the link 

http://20.185.104.88/covid19tracker/


# login to 2nd machine from 1st machine , not exposed to outside world

ssh -i ~/.ssh/id_rsa <<ip-address>>


scp covid19tracker.war covidtracker_azuremol@10.0.1.6:/home/covidtracker_azuremol/covid19tracker.war


repeat the same installation steps dicussed above.



# start tomcat service 


sudo systemctl start tomcat

#Notes: 

The sample source code is forked from https://github.com/microsoft/PowerBI-Developer-Samples/tree/master/Java
Datasets are courtesy of https://github.com/CSSEGISandData/COVID-19
