


# EKILEXi ja Sõnaveebi paigaldusjuhend
Juhendis tuleks asendada järgnevad sõned:

ekilex-IP = (Ekilex masina IP sisevõrgus)  
wordweb-IP = (Sõnaveeb masina IP sisevõrgus)  
ekilexDbPass = andmebaasi kasutaja "ekilex" parool (Ekilex masinas)  
wordwebDbPass = andmebaasi kasutaja "wordweb" parool (Wordweb masinas)  
termEkiUser = Termeki andmebaasi kasutajanimi  
termEkiPass = Termeki andmebaasi parool  


## Enne paigaldust
Eeldame, et virtuaalmasinasse on paigaldatud CentOS 7 minimal.

### Vajalike pakettide paigaldamine
```
yum install ntpdate
timedatectl list-timezones | grep Tallinn
timedatectl set-timezone Europe/Tallinn


yum install git
yum install nano
yum install wget

yum install epel-release
yum install htop
```



### Määra staatiline IP ja hostname
<!--
http://ask.xmodulo.com/configure-static-ip-address-centos7.html
-->

Kasuta tekstipõhist UI-d, et seadistada võrgu parameetrid ja hostname
<!-- "ekilex-test.tb.eki.ee" -->


$ nmtui

Tee läbi mõlemad menüü valikud:  
"Edit a connection" (määra ekilex-IP)  
"Set system hostname"  
Välju UI-st  

$ systemctl restart network.service



### SSH lubamine

Muuda midagi siin, kommenteeri mõned read lahti (ma ei mäleta, mida ma tegin, et see tööle hakkas):

$ nano /etc/ssh/sshd_config

<!--
https://www.putorius.net/2014/07/restarting-services-in-red-hat-7-or.html
https://access.redhat.com/documentation/en-us/red_hat_enterprise_linux/7/html/system_administrators_guide/s1-ssh-configuration
https://www.digitalocean.com/community/tutorials/additional-recommended-steps-for-new-centos-7-servers
-->

$ systemctl enable sshd.service

<!--
ip addr

netstat deprecated
https://unix.stackexchange.com/questions/146190/commands-not-found-netstat-nmap-on-centos-7
https://dougvitale.wordpress.com/2011/12/21/deprecated-linux-networking-commands-and-their-replacements/
https://www.digitalocean.com/community/tutorials/initial-server-setup-with-centos-7
-->





## Paigaldamine

### JAVA

https://tecadmin.net/install-java-8-on-centos-rhel-and-fedora/

cd /opt

wget --no-cookies \
--no-check-certificate \
--header "Cookie: oraclelicense=accept-securebackup-cookie" \
http://download.oracle.com/otn-pub/java/jdk/8u171-b11/512cd62ec5174c3487ac17c61aaa89e8/jdk-8u171-linux-x64.tar.gz \
-O jdk-8-linux-x64.tar.gz

tar xzf jdk-8-linux-x64.tar.gz

-----

$ yum install chkconfig

cd /opt/jdk1.8.0_171/  
alternatives --install /usr/bin/java java /opt/jdk1.8.0_171/bin/java 2  
alternatives --config java  

nano /etc/profile.d/javaenv.sh
```
export JAVA_HOME=/opt/jdk1.8.0_171
export JRE_HOME=/opt/jdk1.8.0_171/jre
export PATH=$PATH:/opt/jdk1.8.0_171/bin:/opt/jdk1.8.0_171/jre/bin
```
chmod 0755 /etc/profile.d/javaenv.sh



### Maven

https://maven.apache.org/install.html

https://www.howtoforge.com/tutorial/centos-apache-maven/
```
cd /opt
wget http://www-eu.apache.org/dist/maven/maven-3/3.5.3/binaries/apache-maven-3.5.3-bin.tar.gz
tar -xf apache-maven-3.5.3-bin.tar.gz
rm -f apache-maven-3.5.3-bin.tar.gz
mv apache-maven-3.5.3/ apache-maven/
```

nano /etc/profile.d/maven.sh
```
# Apache Maven Environment Variables
# MAVEN_HOME for Maven 1 - M2_HOME for Maven 2
export M2_HOME=/opt/apache-maven
export PATH=${M2_HOME}/bin:${PATH}
```
chmod 0755 /etc/profile.d/maven.sh



### Postgres

Paigalda andmebaasi tarkvara Postgres ver 9.6
Operatsioonisüsteemile sobiv versioon leia siit:
https://www.postgresql.org/download/
https://www.postgresql.org/download/linux/redhat/
https://www.postgresql.org/download/linux/redhat/#yum

Select version: 9.6
Select platform: CentOS 7
Select architecture: x86_64
Install the repository RPM:

$ yum install https://download.postgresql.org/pub/repos/yum/9.6/redhat/rhel-7-x86_64/pgdg-centos96-9.6-3.noarch.rpm

Installed:
  pgdg-centos96.noarch 0:9.6-3


Install the client packages:

$ yum install postgresql96

Installed:
  postgresql96.x86_64 0:9.6.9-1PGDG.rhel7

Dependency Installed:
  postgresql96-libs.x86_64 0:9.6.9-1PGDG.rhel7


Optionally install the server packages:

$ yum install postgresql96-server

Installed:
  postgresql96-server.x86_64 0:9.6.9-1PGDG.rhel7


Optionally initialize the database and enable automatic start:

$ /usr/pgsql-9.6/bin/postgresql96-setup initdb

$ systemctl enable postgresql-9.6  
Created symlink from /etc/systemd/system/multi-user.target.wants/postgresql-9.6.service to /usr/lib/systemd/system/postgresql-9.6.service.

$ systemctl start postgresql-9.6



#### Kasutaja ja baasi loomine
https://medium.com/coding-blocks/creating-user-database-and-adding-access-on-postgresql-8bfcd2f4a91e

/// sudo -u postgres psql  
/// \quit  

sudo -u postgres createuser ekilex

// $ sudo -u postgres psql  
// psql=# alter user <username> with encrypted password '<password>';  

$ sudo -u postgres psql  
psql=# alter user ekilex with encrypted password 'ekilexDbPass';

sudo -u postgres createdb --encoding=UTF8 --locale=et_EE.UTF-8 --owner=ekilex --template=template0 ekilex

sudo -u postgres createuser wordweb  
$ sudo -u postgres psql  
psql=# alter user wordweb with encrypted password 'wordwebDbPass';  

sudo -u postgres createdb --encoding=UTF8 --locale=et_EE.UTF-8 --owner=wordweb --template=template0 wordweb

Check:  
sudo -u postgres psql -l  


#### Andmebaasile juurdepääsu seadistamine 

sudo nano /var/lib/pgsql/9.6/data/pg_hba.conf
```
...

# TYPE  DATABASE        USER            ADDRESS                 METHOD

# "local" is for Unix domain socket connections only
local   all             all                                     trust
# IPv4 local connections:
host    all             all             127.0.0.1/32            md5
# IPv6 local connections:
host    all             all             ::1/128                 md5
# Allow replication connections from localhost, by a user with the
# replication privilege.
#local   replication     postgres                                peer
#host    replication     postgres        127.0.0.1/32            ident
#host    replication     postgres        ::1/128                 ident



# Access from Wordweb machine for dblink
host    all             all             0.0.0.0/0                md5
host    all             all             ::/0                     md5

```


Juurdepääsu jaoks Wordweb masinast dblink kaudu

nano /var/lib/pgsql/9.6/data/postgresql.conf
```
listen_addresses = '*'
```

Seadete jõustamiseks:  
sudo systemctl restart postgresql-9.6

<!--
Wordweb masinast:

postgres=# SELECT dblink_connect('host=ekilex-IP user=ekilex password=RootsiKunn1 dbname=ekilex');
ERROR:  could not establish connection
DETAIL:  FATAL:  no pg_hba.conf entry for host "wordweb-IP", user "ekilex", database "ekilex", SSL off


https://dba.stackexchange.com/questions/83984/connect-to-postgresql-server-fatal-no-pg-hba-conf-entry-for-host

http://suite.opengeo.org/docs/latest/dataadmin/pgGettingStarted/firstconnect.html

https://blog.bigbinary.com/2016/01/23/configure-postgresql-to-allow-remote-connection.html

-->









## Rakendustarkvara


### Tarkvaraprojekt Ekileks (lähtekoodi paigaldamine)

sudo mkdir /apps  
cd /apps  
sudo chown *kasutaja* .  
mkdir source  
cd source/  

git clone https://github.com/tripledev/ekilex.git

cd ekilex  

git fetch  
git branch -a  

///uus ver  
git checkout **1.1.0**  


///Tekitada kataloogid:  

mkdir data  
mkdir data/files  
mkdir logs  




### Sõnakogude laadimine

#### Sõnakogude laadurid

Sõnakogusid saab laadida ükshaaval või kõik korraga (ultima-loader). Järgnevalt kasutame viimast.

#### Konfigureerimine

nano /apps/source/ekilex/ekilex-etl/envresources/prod/ekilex-etl.properties
```
db.ekilex.url = jdbc:postgresql://localhost:5432/ekilex
db.ekilex.usr = ekilex
db.ekilex.psw = ekilexDbPass

db.termeki.url = jdbc:mysql://termbases.eu/tb_live?useSSL=false&zeroDateTimeBehavior=convertToNull
db.termeki.usr = termEkiUser
db.termeki.psw = termEkiPass

termeki.file.service.url=https://www.termbases.eu/iframe/conceptimage/getfile

file.repository.path=/apps/data/files/
```

nano /apps/source/ekilex/ekilex-etl/envresources/prod/ultima-loader.properties
```
mab.data.file=/apps/data/dicts/mab.xml
ss1.data.file=/apps/data/dicts/ss1.xml
ss1.map.file.1=
ss1.map.file.2=
psv.data.file=/apps/data/dicts/psv.xml
kol.data.file=/apps/data/dicts/kol.xml
qq2.data.file=/apps/data/dicts/qq2.xml
ev2.data.file.1=/apps/data/dicts/ev21.xml
ev2.data.file.2=/apps/data/dicts/ev22.xml
est.data.file=/apps/data/dicts/esterm.xml
termeki.data.file=/apps/data/dicts/termeki-databases.csv
doreports=false

```
Logimise määrangud asuvad:  
/apps/source/ekilex/ekilex-etl/envresources/prod/logback.xml  


#### Sõnakogude failid

Vajalike andmefailide paigaldamine (variandid):  
a) Kopeeri ekitest.tripledev.ee serverilt:  
/var/apps/file_storage/\* > /apps/data/files/\* 
/var/apps/data/\* > /apps/data/dicts/\* 
b) Küsi sõnakogude omanikelt pakitud failid ja paki lahti (asenda versiooni nr failinimes sobivaga):  
mkdir /apps/data/dicts  
mkdir /apps/data/files  
tar -xzvf ekilex-dicts-1.1.0.tar.gz /apps/data/dicts  
tar -xzvf ekilex-files-1.1.0.tar.gz /apps/data/files  
rm ekilex-dicts-1.1.0.tar.gz  
rm ekilex-files-1.1.0.tar.gz  

#### Ehitamine  
/ekilex/ekilex-etl>mvn clean install -D skipTests -P prodsrvall

#### Käivitamine  
/ekilex/ekilex-etl>mvn exec:java -P prodsrvall


Laadimise edenemist ja õnnestumist saab jälgida määratud logifailist. Sõnakogud on laetud, kui
logi lõppeb teatega: „DONE LOADING DATASETS!!“






### Veebirakendus Ekileks

#### Konfigureerimine

Vaja konfida teenuse pordid, andmebaasi juurdepääs, logi asukoht, andmefailide asukoht.

nano /apps/source/ekilex/ekilex-app/src/main/resources/application-prod.properties

```
server.port=5555
server.servlet.context-path=/ekilex
server.servlet.session.timeout=24h

tomcat.ajp.port=5557
tomcat.ajp.enabled=true

spring.datasource.url=jdbc:postgresql://localhost:5432/ekilex
spring.datasource.username=ekilex
spring.datasource.password=ekilexDbPass

logging.level.root=warn
logging.level.eki.ekilex=debug
logging.level.eki.common=debug
logging.level.org.jooq=debug
logging.path=/apps/logs
logging.file=ekilex

file.repository.path=/apps/data/files/
```

Failiressursid – pildid, hääldused, jms. Sisu kohta küsi täpsemalt arendajatelt.
TODO!


#### Ehitamine

/ekilex>mvn clean install -D skipTests


#### Käivitamine
Nii:  
/ekilex/ekilex-app> mvn spring-boot:run -D spring-boot.run.profiles=prod

Või nii:  
java -jar /apps/source/ekilex/ekilex-app/target/ekilex-app.jar --spring.profiles.active=prod


#### Ekilex-rakenduse kasutajate lisamine (Login)
su - postgres
> psql
```
\connect ekilex
insert into eki_user (name, email, password, roles) values ('Armas Tähetark', 'armas@nowhere.com', '$2a$10$t8A6FTC2n5Q8dfshCKBe5e5vkqDcq722MKdCYwF/I.mQ3X7e6y5IK', '{basic_user}');
insert into eki_user (name, email, password, roles) values ('Kaur M', 'kaur@hacki.ee', '$2a$10$14Y.SvY66HbFPdUU6ChXduj.P9xcsQzv3Q8I4rOdN4NgnoE.WN2oW', '{basic_user}');

COMMIT;
```

#### Tulemüüri konfimine
TODO: Järgnev on mulle natuke hämar. Mis värk nende zone'idega on?

firewall-cmd --get-default-zone  
firewall-cmd --list-all-zones  

```
firewall-cmd --permanent --zone=public --add-port=5555/tcp
firewall-cmd --permanent --zone=external --add-port=5555/tcp

firewall-cmd --permanent --zone=public --add-port=5557/tcp
firewall-cmd --permanent --zone=external --add-port=5557/tcp

firewall-cmd --permanent --zone=public --add-port=5432/tcp 
firewall-cmd --permanent --zone=external --add-port=5432/tcp 

firewall-cmd --reload
```
Postgresqli port 5432 on avatud eraldiseisva Sõnaveebi masina jaoks

//java avab pordi ainult ipv6 peal?

firewall-cmd --list-ports  
lsof -i -P  
lsof -i4 -P  
lsof -i6 -P  

$ yum install net-tools  
$ netstat -tan  




---------------
( siin teen Ekilex VM-ist koopia Sõnaveebi jaoks)

---------------

## Veebirakendus Sõnaveeb (omaette VM-is)

### Määra staatiline IP ja hostname

Kasuta tekstipõhist UI-d, et seadistada võrgu parameetrid (wordweb-IP) ja hostname.
<!-- "sonaveeb-test.tb.eki.ee"? -->


$ nmtui

Tee läbi mõlemad menüü valikud:  
"Edit a connection" (määra wordweb-IP)  
"Set system hostname"  
Välju UI-st  

$ systemctl restart network.service


### Konfigureerimine

Konfigureeri toodangukeskkonna-spetsiifiliste määrangute fail  
nano /apps/source/ekilex/wordweb-app/src/main/resources/application-prod.properties

```
#Rakendusserveri parameetrid
server.port=5577
server.servlet.context-path=/wordweb
server.servlet.session.timeout=60m

tomcat.ajp.port=5578
tomcat.ajp.enabled=true

#Andmebaasi ühenduse kirjeldus
spring.datasource.url=jdbc:postgresql://localhost:5432/wordweb
spring.datasource.username=wordweb
spring.datasource.password=wordwebDbPass

logging.level.root=warn
logging.level.eki.wordweb=debug
logging.level.eki.common=debug
logging.level.org.jooq=debug
logging.path=/apps/logs
logging.file=wordweb

file.repository.path=/apps/data/files/

#alternatively synthesiser can be installed locally
#speech.synthesizer.path=
speech.synthesizer.service.url=http://heliraamat.eki.ee/syntees/koduleht.php
speech.recognition.service.url=ws://bark.phon.ioc.ee:82/dev/duplex-speech-api/ws/speech
corpora.service.url=https://korp.keeleressursid.ee/cgi-bin/kuuskorp.cgi

```


#### Tulemüüri konfimine

firewall-cmd --permanent --zone=public --add-port=5577/tcp  
firewall-cmd --permanent --zone=public --add-port=5578/tcp  
firewall-cmd --permanent --zone=external --add-port=5577/tcp  
firewall-cmd --permanent --zone=external --add-port=5578/tcp  
firewall-cmd --reload  

//ei näikse toimivat...
//kasutan siis samu porte, mis ekilex: 5555 ja 5557  
TODO: Muuda ära ka eelmises peatükis (/apps/source/ekilex/wordweb-app/src/main/resources/application-prod.properties)

#### Andmebaasi konfimine 

##### Link ekilex baasi

$ yum install postgres*contrib  

$ sudo -u postgres psql  
CREATE EXTENSION dblink;  
SELECT dblink_connect('host=ekilex-IP user=ekilex password=ekilexDbPass dbname=ekilex');  

##### Materjaliseeritud vaadete loomine
Kõigepealt modifitseerin create_mviews.sql skripti, siis käivitan selle.
```
sed -i -e 's/password=3kil3x/password=ekilexDbPass/g' /apps/source/ekilex/wordweb-app/fileresources/sql/create_mviews.sql  
sed -i -e 's/host=localhost/host=ekilex-IP/g' /apps/source/ekilex/wordweb-app/fileresources/sql/create_mviews.sql  
sudo -u postgres psql -U wordweb -d wordweb -a -f /apps/source/ekilex/wordweb-app/fileresources/sql/create_mviews.sql  
```
#### Ehitamine

Kogu tarkvaraprojekti ehitamine:  
/ekilex>mvn clean install -D skipTests

Sõnaveebi rakenduse ehitamine:  
/ekilex/wordweb-app>mvn clean install -D skipTests

#### Käivitamine

Maven pistaku vahendusel:  
/ekilex/wordweb-app>mvn spring-boot:run -D spring-boot.run.profiles=prod



--------------

#### Rakenduste käivitamine systemd teenusena

##### Rakendus Ekilex Ekilexi masinas

Loo sobiv Linux kasutaja, kellena rakendust hakatakse käivitama. See ei tohiks olla root kasutaja!  
Käesolevas juhendis on selleks kasutajaks "**kasutaja**".
```
mkdir /apps/deploy
mkdir /apps/deploy/ekilex

cp /apps/source/ekilex/ekilex-app/target/ekilex-app.jar /apps/deploy/ekilex  
chmod 755 /apps/deploy/ekilex/ekilex-app.jar
```
Jälgi, et .jar fail (ja kogu /apps kataloogipuu) oleks ligipääsetav "kasutaja"-le.  

nano /apps/deploy/ekilex/ekilex-app.conf
```
JAVA_OPTS=-Xmx4096M
RUN_ARGS=--spring.profiles.active=prod
```

sudo bash  
nano /etc/systemd/system/ekilex.service
```
[Unit]
Description=EKILEX application
After=syslog.target
[Service]
User=kasutaja

ExecStart=/apps/deploy/ekilex/ekilex-app.jar
WorkingDirectory=/apps/deploy/ekilex
Environment="JAVA_HOME=/opt/jdk1.8.0_171"
SuccessExitStatus=143
[Install]
WantedBy=multi-user.target
```



systemctl enable ekilex  
Created symlink from /etc/systemd/system/multi-user.target.wants/ekilex.service to /etc/systemd/system/ekilex.service.  

systemctl start ekilex  
//systemctl restart ekilex  
//systemctl stop ekilex  

------
Kui ei hakka tööle (v 1.1.0)...  
systemctl start ekilex  
systemctl status ekilex  
```
[root@ekilex-test ekilex]# systemctl status ekilex
● ekilex.service - EKILEX application
   Loaded: loaded (/etc/systemd/system/ekilex.service; enabled; vendor preset: disabled)
   Active: failed (Result: exit-code) since Mon 2018-09-17 02:02:16 EEST; 2s ago
  Process: 2131 ExecStart=/apps/deploy/ekilex/ekilex-app.jar (code=exited, status=203/EXEC)
 Main PID: 2131 (code=exited, status=203/EXEC)

Sep 17 02:02:16 ekilex-test.tb.eki.ee systemd[1]: Started EKILEX application.
Sep 17 02:02:16 ekilex-test.tb.eki.ee systemd[1]: Starting EKILEX application...
Sep 17 02:02:16 ekilex-test.tb.eki.ee systemd[1]: ekilex.service: main process exited, code=exited, status=203/EXEC
Sep 17 02:02:16 ekilex-test.tb.eki.ee systemd[1]: Unit ekilex.service entered failed state.
Sep 17 02:02:16 ekilex-test.tb.eki.ee systemd[1]: ekilex.service failed.
```

... kontrolli, et /apps/source/ekilex/ekilex-app/pom.xml sisaldaks
```
<plugin>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-maven-plugin</artifactId>
	<configuration>
		<executable>true</executable>
	</configuration>
</plugin>
```
... ja ehita uuesti. V 1.1.0 ei sisaldanud seadet "fully executable jar". https://docs.spring.io/spring-boot/docs/current/reference/html/deployment-install.html














## Väline veebiserver / pöördproksi / koormusjaotur

Eraldi avaliku IP-ga masinas.

#### APACHE HTTPD?

https://www.linode.com/docs/web-servers/apache/install-and-configure-apache-on-centos-7/


#### NGINX

https://www.nginx.com/resources/wiki/start/topics/examples/likeapache/

Apache JServ Protocol (AJP)?:

https://github.com/yaoweibin/nginx_ajp_module

HTTP protokolliga:
```
server {
    listen       väline-IP:80;
    listen       väline-IP:443 ssl;
    server_name  väline.domeeni.nimi;

    ssl_certificate     /etc/nginx/ssl/ssl_chained.crt;
    ssl_certificate_key /etc/nginx/ssl/private/ssl_priv.key;

    access_log  /var/log/nginx/test.access.log;
    error_log  /var/log/nginx/test.error.log;

    location /wordweb/ {
        proxy_pass  http://wordweb-IP:5555/wordweb/;
        proxy_redirect http://  $scheme://;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header Host $host;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
    }

    ## at the moment only for /ekilex/ ##
    location / {
        proxy_pass  http://ekilex-IP:5555;
        proxy_redirect http://  $scheme://;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header Host $host;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
    }

}
```


<!--stackedit_data:
eyJoaXN0b3J5IjpbLTU5OTY2NzU2OSwtMTkzODIwMzkwMSw0Nz
Q1MTAwNDAsLTQ4ODM5NjA1NCwtNzkxNjEyNzQ5LC0xNDI4NDUx
MzQxLDIwNjg5NjAyMTUsLTIxMjg5OTMwNzAsMTc0ODU3MTY1Ny
wxMDkwNDM3ODkzLC0xOTQ0NTU1MzY5LDMyMDQ5MzUzOSwtMTYx
MTEzOTAzMywtMjAxODM4MDkzOSwxNTM4NDA0MTQ5LC0xMTI2OT
EzMTksLTE0MDY4NjM5NywtNTExMjU2MDU4LDE2MzA1MTAxNzcs
OTEzMDY0NjY1XX0=
-->