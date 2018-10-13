import urllib2

# 直接请求
response = urllib2.urlopen('http://www.baidu.com')
print(response.getCode())
