# Using OpenJDK 8
# This Dockerfile does not require any files that are in the GATK4 repo.
FROM maprtech/data-science-refinery:v1.1_6.0.0_4.1.0_ubuntu16

#### Basic image utilities
RUN apt-get update && \
     apt-get upgrade -y && \
     apt-get install -y python && \
     apt-get install -y python3-pip && \
     apt-get install -y wget curl unzip gcc python-dev python-setuptools git less lynx hdfview
##########

# Install some more useful tools
RUN apt-get install -y \
 aufs-tools \
 automake \
 bedtools \
 btrfs-tools \
 build-essential \
 dpkg-sig \
 iptables \
 samtools \
 software-properties-common

COPY install_R_packages.R install_R_packages.R
RUN Rscript install_R_packages.R
