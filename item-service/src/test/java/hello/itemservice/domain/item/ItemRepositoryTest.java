package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        Item item = new Item("itemA", 10000, 10);
        Item savedItem = itemRepository.save(item);
        Item findItem = itemRepository.findById(savedItem.getId());

        assertThat(findItem).isEqualTo(savedItem);
    }

    @Test
    void findAll() {
        Item item1 = new Item("itemA", 10000, 10);
        Item item2 = new Item("itemB", 20000, 10);

        itemRepository.save(item1);
        itemRepository.save(item2);

        List<Item> findItems = itemRepository.findAll();

        assertThat(findItems.size()).isEqualTo(2);
        assertThat(findItems).contains(item1, item2);
    }

    @Test
    void updateItem() {
        Item item1 = new Item("itemA", 10000, 10);
        Item savedItem = itemRepository.save(item1);
        Long itemId = savedItem.getId();

        Item updateParam = new Item("item2", 20000, 20);
        itemRepository.update(itemId, updateParam);

        Item findItem = itemRepository.findById(itemId);
        assertThat(findItem.getName()).isEqualTo(updateParam.getName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());
    }

}