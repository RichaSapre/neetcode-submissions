class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pre : prerequisites){
            if(map.containsKey(pre[1])){
                map.get(pre[1]).add(pre[0]);
            }
            else{
                List<Integer> nextCourse = new LinkedList<>();
                nextCourse.add(pre[0]);
                map.put(pre[1],nextCourse);
            }
        }
        HashSet<Integer> visited = new HashSet<>();

        for( int currCourse = 0; currCourse<numCourses; currCourse++){
            if(courseSchedule(currCourse, visited, map) == false){
                return false;
            }
        }
        return true;
    }

    public boolean courseSchedule(int course, HashSet<Integer> visited, HashMap <Integer, List<Integer>> map){
        if(visited.contains(course)){
            return false;
        }
        if(map.get(course) == null) return true;

        visited.add(course);
        for(int pre : map.get(course)){
            if(courseSchedule(pre,visited,map) == false) return false;
        }
        visited.remove(course);
        map.put(course,null);
        return true;
    } 
}
