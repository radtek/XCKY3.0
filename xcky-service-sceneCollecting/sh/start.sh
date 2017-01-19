source /etc/profile
myJar=conf
for i in `ls /opt/server/xcky/lib/xcky-service-sceneCollecting*.jar`
do
        myJar=$myJar:$i
        chmod u+x $i
done
eval exec "java -cp $myJar com.hisign.xcky.service.main.ServiceProvider &"
