package codingNinjas23;
import java.util.ArrayList;

class MapNode<K,V>{
	K key;
	V value;
	public MapNode<K,V> next;
	MapNode(K key, V value){
		this.key = key;
		this.value = value;
		next = null;
	}
}
public class Map<K,V> {
	int size;
	int bucketSize;
	ArrayList<MapNode<K,V>> bucketList;
	public Map(){
		size = 0;
		bucketSize = 11;
		bucketList = new ArrayList<MapNode<K,V>>();
		for(int i = 0;i < bucketSize;++i){
			bucketList.add(null);
		}
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
	private int getBucketIndex(K key){
	int hashcode = key.hashCode();
	int bucketIndex = hashcode%bucketSize;
	if(bucketIndex<0){
		bucketIndex = bucketIndex + bucketSize;
		}
	return bucketIndex;
	}
	public void remove(K key){
		int index = getBucketIndex(key);
		MapNode<K,V> head = bucketList.get(index);
		MapNode<K,V> prev = null;
		if(head.key.equals(key)){
			prev.next = head.next;
			return ;
		}
		while(head!=null)
		{	if(head.key.equals(key)){
			prev.next = head.next;
		}
			prev = head;
			head = head.next;
		}
	}
	public void add(K key,V value){
		int index = getBucketIndex(key);
		MapNode<K,V> node = new MapNode<>(key, value);
		MapNode<K,V> head = bucketList.get(index);
		MapNode<K, V> temp = head;
		while(temp!=null){
			if(temp.key.equals(key)){
				temp.value = value;
				return;
			}
			temp = temp.next;
		}
		node.next = head;
		bucketList.set(index,node);
		size++;
		rehash();
		return;
		
	}
	public V get(K key){
		int index = getBucketIndex(key);
		MapNode<K,V> head = bucketList.get(index);
		while(head!=null)
		{	if(head.key.equals(key)){
			return head.value;
			}
			head = head.next;
		}
		return null;
	}
	private void rehash(){
		if((size*1.0)/bucketSize>0.7){
			size = 0;
			bucketSize = bucketSize*2;
			ArrayList<MapNode<K,V>> temp = bucketList;
			bucketList = new ArrayList<MapNode<K,V>>();
			for(int i=0;i<bucketSize;++i){
				bucketList.add(null);
			}
			for(MapNode<K,V> head : temp){
				MapNode<K,V> node = head;
				while(node!=null){
					add(node.key,node.value);
					node = node.next;
				}
			}
			
		}
	}

}
