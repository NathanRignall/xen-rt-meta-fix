SUMMARY = "An example kernel recipe that uses the linux-yocto and oe-core"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://git.yoctoproject.org/linux-yocto.git;branch=${KBRANCH};name=machine;protocol=https \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-6.1;destsuffix=${KMETA};protocol=https"

LINUX_VERSION ?= "6.1.65"
LINUX_VERSION_EXTENSION:append = "-custom-rt"

SRCREV_machine="240864a8ef2b2c21c8df8fd92d8b26e3e4f1fd44"
SRCREV_meta="7ca3655cbccce6330c6f947abf667b5e3ae5350b"

PV = "${LINUX_VERSION}+git"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "1"

LINUX_KERNEL_TYPE = "preempt-rt"

KBRANCH:raspberrypi4-64 ?= "v6.1/standard/preempt-rt/bcm-2xxx-rpi"
KMACHINE:raspberrypi4-64 ?= "bcm-2xxx-rpi4"
KMETA:raspberrypi4-64 ?= "bcm-2xxx-rpi4"
COMPATIBLE_MACHINE:raspberrypi4-64 = "(raspberrypi4-64)"

KERNEL_EXTRA_FEATURES ?= "features/netfilter/netfilter.scc features/taskstats/taskstats.scc"
KERNEL_FEATURES:append = " ${KERNEL_EXTRA_FEATURES}"
