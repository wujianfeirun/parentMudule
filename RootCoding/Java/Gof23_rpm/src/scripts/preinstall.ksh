#! /bin/ksh
#ident "%W%"

##############build path##############
HOSTNAME=`hostname`
FUSION_VERSION=%{version}
## ref package
GOF_TMP=/opt/gof-tmp
GOF_BASEDIR=/opt/gof
GOF_BASEDIR_V=/opt/gof/${FUSION_VERSION}
GOF_BASEDIR_LIB=/opt/gof/lib
GOF_BASEDIR_BIN=/opt/gof/bin

echo "start preinstall script"
echo "gof version ${FUSION_VERSION}"

############ remove ref package ########
if [ -L $GOF_BASEDIR_LIB ];then
    unlink $GOF_BASEDIR_LIB
    echo "$GOF_BASEDIR_LIB unlinked"
fi

if [ -L $GOF_BASEDIR_BIN ];then
    unlink $GOF_BASEDIR_BIN
    echo "$GOF_BASEDIR_BIN unlinked"
fi

if [ -d $GOF_BASEDIR_V ];then
    unlink $GOF_BASEDIR_V
    echo "$GOF_BASEDIR_V unlinked"
fi

if [ -d $GOF_TMP ];then
    unlink $GOF_TMP
    echo "$GOF_TMP unlinked"
fi
