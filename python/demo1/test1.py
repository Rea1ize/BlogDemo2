'''
python列表讲解
'''
list = [1, 2, 3, 4, 5]  # 声明列表

print("list列表的最大值为:", max(list))
print("list列表的最小值为:", min(list))
print("统计元素1在列表中出现的个数",list.count(1))
#清空列表
list.clear()


print()
print(list)  # 输出列表
print("list列表的第一个数据", list[0])
print("list列表的第二个数据", list[1])
print("list列表的第三个数据", list[2])
print("list列表的第四个数据", list[3])
print("list列表的第五个数据", list[4])

print()
list2 = [1, 3.6, True, False, "你好，世界"]
print("list1列表的第一个数据，int型", list2[0])
print("list2列表的第二个数据，float型", list2[1])
print("list2列表的第三个数据, bool型", list2[2])
print("list2列表的第四个数据, bool型", list2[3])
print("list2列表的第五个数据, String型", list2[4])

# 增加数据,在末尾增加666这个数据
list2.append(666)
# 删除数据
del list2[0]
print(list2)  # 输出列表
# 修改数据
list2[3] = "修改后的数据"
print(list2)  # 输出列表
