class Day2 {

    fun calcWrappingPaper(length: Int, width: Int, height: Int): Long{
        val area1 = length * width
        val area2 = width * height
        val area3 = height * length
        return  2L * area1 +
                2L * area2 +
                2L * area3 +
                minOf(area1, area2, area3)
    }

    fun calcTotalArea(data: List<String>): Long {
        return data.sumOf { dimensions ->
            dimensions.split("x")
                .map { it.toInt() }
                .let { calcWrappingPaper(it[0],it[1],it[2]) } }
    }

    fun calcRibbonToWrap(length: Int, width: Int, height: Int): Int {
        val list = listOf(length,width,height).sorted()
        return list[0]+ list[0] + list[1] + list[1]
    }

    fun calcRibbonForBow(length: Int, width: Int, height: Int): Int {
        return length * width * height
    }

    fun calcRibbon(length: Int, width: Int, height: Int): Int {
        return calcRibbonForBow(length, width, height) + calcRibbonToWrap(length, width, height)
    }

    fun calcTotalRibbon(data: List<String>): Int {
        return data.sumOf { dimensions ->
            dimensions.split("x")
                .map { it.toInt() }
                .let { calcRibbon(it[0],it[1],it[2]) } }
    }
}