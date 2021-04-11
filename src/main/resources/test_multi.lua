--
-- Created by IntelliJ IDEA.
-- User: Administrator
-- Date: 2021/2/26
-- Time: 21:32
-- To change this template use File | Settings | File Templates.
--
-- 简单的 table
--mytable = {}
--print("mytable 的类型是 ",type(mytable))
--
--mytable[1]= "Lua"
--mytable["wow"] = "修改前"
--print("mytable 索引为 1 的元素是 ", mytable[1])
--print("mytable 索引为 wow 的元素是 ", mytable["wow"])
--
---- alternatetable和mytable的是指同一个 table
--alternatetable = mytable
--
--print("alternatetable 索引为 1 的元素是 ", alternatetable[1])
--print("mytable 索引为 wow 的元素是 ", alternatetable["wow"])
--
--alternatetable["wow"] = "修改后"
--
--print("mytable 索引为 wow 的元素是 ", mytable["wow"])
--
---- 释放变量
--alternatetable = nil
--print("alternatetable 是 ", alternatetable)
--
---- mytable 仍然可以访问
--print("mytable 索引为 wow 的元素是 ", mytable["wow"])
--
--mytable = nil
--print("mytable 是 ", mytable)

--print("sdfsd")
--result = {}
--result[1] = -1
--result["wow"] = "修改前"
--
--print("mytable 索引为 wow 的元素是 ", result["wow"])
--for k, v in ipairs(result) do
--    print(k, v)
--end


--fruits = {"banana","orange","apple","grapes"}
--print("排序前")
--for k,v in ipairs(fruits) do
--    print(k,v)
--end
--
--table.sort(fruits)
--print("排序后")
--for k,v in ipairs(fruits) do
--    print(k,v)
--end
--return result


local function delete()
    print("hello world")
    local result = {}
    result.permit = -1
    result.cert_id = -1

    return result;
--    return 7;
end

return delete()
