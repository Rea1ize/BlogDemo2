'''
python字典
'''
stu = {'name': "tonjies", "age": "20", "age": "sss", "school": "清华大学2135公里外的岭南学院"}
print("根据key name取出姓名：", stu['name'])
print("根据key age取出年龄：", stu['age'])
print("根据key school取出学校：", stu['school'])

# 修改数据元素
stu['age'] = 21
print(stu["age"])

# 删除字典数据
del stu['age']
print(stu)

# 计算字典的长度
print(len(stu))
# 判断变量是否是字典类型，是的话返回<class 'dict'>
print(type(stu))
# 清空字典的所有元素
stu.clear()

# 判断一个键在字典中时候存在
if 'name' in stu:
    # 如果存在，输出值
    print(stu['name'])
else:
    # 如果不存在，输出不存在
    print("该键在字典中不存在")
