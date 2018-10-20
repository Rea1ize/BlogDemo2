'''
集合
'''
list = ['小红', '小紫', '小紫'] #声明列表
print(list) #输出列表

set = {'小红', '小紫', '小紫'} #声明集合
print(set) #输出集合
set.add("小蓝")#添加元素
set.remove("小红")#移除元素
print(len(set))#计算元素个数
set.clear()#清除元素
print(set)