'''
集合
'''
list = ['小红', '小紫', '小紫']
print(list)

s = {'小红', '小紫', '小紫'}
print(s)
s.add("小蓝")#添加元素
s.remove("小红")#移除元素
print(len(s))#计算元素个数
s.clear()#清除元素
print(s)