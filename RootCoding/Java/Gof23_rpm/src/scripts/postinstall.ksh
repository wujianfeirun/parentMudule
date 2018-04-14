#! /bin/ksh
#ident "%W%"

OWNER="jw18233"
GROUP="jw18233"

echo "start postinstall script"

###############hostname and version################
HOSTNAME=`hostname`
echo "Hostname: ${HOSTNAME}"
GOF_VERSION=${version}
echo "FUSION_VERSION: ${GOF_VERSION}"

#######################redirect output##############
if [ -d /opt/gof ];then
    mkdir -p /opt/gof/
    echo "create path: /opt/gof/"
fi

#######################redirect output##############
GOF_TMP=/opt/gof-tmp
GOF_TMP_V=/opt/gof-tmp/${GOF_VERSION}
GOF_BASEDIR=/opt/gof
GOF_BASEDIR_V=/opt/gof/${GOF_VERSION}
GOF_BASEDIR_LIB=/opt/gof/lib
GOF_BASEDIR_LIB_V=/opt/gof/lib/${GOF_VERSION}
GOF_BASEDIR_BIN=/opt/gof/bin
GOF_BASEDIR_BIN_V=/opt/gof/bin/${GOF_VERSION}

#######################copy version from tmp #############################
cp -a $GOF_TMP_V $GOF_BASEDIR_V
rm -rf $GOF_TMP

echo "copy $GOF_TMP_V $GOF_BASEDIR_V"
echo "remove $GOF_TMP"

##############lind gof############
ln -s $GOF_BASEDIR_LIB_V $GOF_BASEDIR_LIB
ln -s $GOF_BASEDIR_BIN_V $GOF_BASEDIR_BIN

################dos2unix###################
find /opt/gof/bin/ -regex "*.ksh" |xargs -r -n 1 dos2unix

#################chomd,chown#################
chmod -R 755 $GOF_BASEDIR
chown -R $OWNER:$GROUP $GOF_BASEDIR

###################sync memory#######################
sync
echo "successed install version is $GOF_VERSION"

######################mail report########################
STAT="$?"
/usr/bin/Mail -s "gof package installed on $HOSTNAME --env...." dl.gt.global.futures.fusion.dev@imcnam.ssmb.com < "gof building"

